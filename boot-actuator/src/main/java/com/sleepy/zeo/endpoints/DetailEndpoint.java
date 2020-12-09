package com.sleepy.zeo.endpoints;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * actuator模块: 调用url => 调用Endpoint中接口
 */

// 自定义Endpoint
// id不能用驼峰命名法，多个单次需要用-进行分割
@Endpoint(id = "detail")
@Component
public class DetailEndpoint {

    private static final Log logger = LogFactory.getLog(DetailEndpoint.class);

    private Map<String, Map<String, Object>> details;
    private int detailsId = 1001;

    public DetailEndpoint() {
        logger.info("EventEndpoint constructor");
        details = new HashMap<>();
        Map<String, Object> detail = new HashMap<>();
        detail.put("name", "sleepy zeo");
        detail.put("age", 12);
        detail.put("desc", "Cyberpunk 2077 wins");
        details.put("id" + detailsId++, detail);
        Map<String, Object> detail2 = new HashMap<>();
        detail2.put("name", "Donald");
        detail2.put("age", 78);
        detail2.put("desc", "GTA VI");
        details.put("id" + detailsId++, detail2);
        Map<String, Object> detail3 = new HashMap<>();
        detail3.put("name", "biden");
        detail3.put("age", 82);
        detail3.put("desc", "League of Legends");
        details.put("id" + detailsId++, detail3);
    }

    // $ curl http://127.0.0.1:8899/actuator/detail
    @ReadOperation
    public Map<String, Map<String, Object>> detail() {
        return details;
    }

    // $ curl http://127.0.0.1:8899/actuator/detail/1002
    @ReadOperation
    public Object detail(@Selector int id) {
        return details.get("id" + id);
    }

    // $ curl -X POST -H "Content-Type: application/json" -d '{"name":"Obama","age":47,"desc":"Ben Latin"}' http://127.0.0.1:8899/actuator/detail
    @WriteOperation
    public void addOrUpdate(String name, int age, String desc) {
        Map<String, Object> detail = new HashMap<>();
        detail.put("name", name);
        detail.put("age", age);
        detail.put("desc", desc);
        details.put("id" + detailsId++, detail);
    }

    // $ curl -X DELETE http://127.0.0.1:8899/actuator/detail
    @DeleteOperation
    public String delete() {
        details.clear();
        return "success";
    }

    // $ curl -X DELETE http://127.0.0.1:8899/actuator/detail/1003
    @DeleteOperation
    public String delete(@Selector int id) {
        details.remove("id" + id);
        return "success";
    }
}


