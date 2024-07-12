package org.zz.spring.guide.annotation.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.zz.spring.guide.annotation.aop")
@EnableAspectJAutoProxy
public class ApplicationContextConfig {
}
