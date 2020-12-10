package com.sleepy.zeo.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JBConfig {

    // 该bean的名称为"createA"
    @Bean
    public A createA() {
        System.out.println("createA");
        return new A();
    }

    // 该bean的名称为"createAImage"
    @Bean
    public A createAImage() {
        System.out.println("createAImage");
        return new A();
    }

    @Bean
    public B createB() {
        System.out.println("createB");
        return new B();
    }

    @Bean
    public C createC() {
        System.out.println("createC");
        return new C();
    }

    public static class A {
        public A() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            return "A: " + this.hashCode();
        }
    }

    public static class B {
        public B() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            return "B: " + this.hashCode();
        }
    }

    public static class C {
        public C() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            return "C: " + this.hashCode();
        }
    }
}
