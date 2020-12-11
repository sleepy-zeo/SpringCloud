package com.sleepy.zeo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤: filter只针对需要路由的url，普通的url不会过滤
 */
@Component
public class ServiceFilter extends ZuulFilter {

    private static Log logger = LogFactory.getLog(ServiceFilter.class);

    /**
     * 过滤器的类型
     *
     * "pre" for pre-routing filtering
     * "route" for routing to an origin
     * "post" for post-routing filters
     * "error" for error handling
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @return 过滤器在过滤器链中的位置
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * @return true表示run()被调用，否则不被调用
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        Object accessToken = httpServletRequest.getParameter("token");
        if (accessToken == null) {
            logger.warn("error, token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                logger.error(e);
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
