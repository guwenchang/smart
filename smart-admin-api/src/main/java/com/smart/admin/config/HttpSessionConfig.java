package com.smart.admin.config;

import com.smart.common.consts.Constant;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * @author Gu Xiaobai
 * @date 2017/7/17 16:08
 */
@EnableRedisHttpSession(redisNamespace = "smart-admin")
public class HttpSessionConfig {
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        HeaderHttpSessionStrategy headerHttpSessionStrategy = new HeaderHttpSessionStrategy();
        headerHttpSessionStrategy.setHeaderName(Constant.TOKEN_KEY);
        return headerHttpSessionStrategy;
    }
}
