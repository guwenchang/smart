package com.smart.admin.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.smart.admin.interceptor.ApiInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * MVC配置
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-20 22:30
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
    @Autowired
    private ApiInterceptor apiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor).addPathPatterns("/**")
        .excludePathPatterns("/swagger/**").excludePathPatterns("/v2/api-docs");
    }

    /**
     * 添加fastJsonHttpMessageConverter到converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        logger.debug("configureMessageConverters");

        converters.add(fastJsonHttpMessageConverter());
    }

    /**
     * fastJson相关设置
     */
    private FastJsonConfig getFastJsonConfig() {
        logger.debug("fastJsonConfig");

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 在serializerFeatureList中添加转换规则
        List<SerializerFeature> serializerFeatureList = new ArrayList<SerializerFeature>();
        serializerFeatureList.add(SerializerFeature.WriteMapNullValue);
        serializerFeatureList.add(SerializerFeature.WriteNullListAsEmpty);
        serializerFeatureList.add(SerializerFeature.WriteDateUseDateFormat);
        SerializerFeature[] serializerFeatures = serializerFeatureList.toArray(new SerializerFeature[serializerFeatureList.size()]);
        fastJsonConfig.setSerializerFeatures(serializerFeatures);

        return fastJsonConfig;
    }

    /**
     * fastJson相关设置
     */
    private FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter() {
        logger.debug("fastJsonHttpMessageConverter");

        FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter4();

        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.parseMediaType("application/json;charset=UTF-8"));
        supportedMediaTypes.add(MediaType.parseMediaType("text/html;charset=UTF-8"));

        fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(getFastJsonConfig());

        return fastJsonHttpMessageConverter;
    }


}