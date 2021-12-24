package com.lianxing.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author lianxing
 * @description
 * @create 2021-11-20 20:39
 */
@Configuration
@ComponentScan(basePackages="com.lianxing")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
