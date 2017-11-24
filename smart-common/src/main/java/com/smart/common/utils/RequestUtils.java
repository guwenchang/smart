package com.smart.common.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
* 请求处理工具类
* @author xiaobai
* @date 2017/10/29 15:05
**/

public class RequestUtils {

    public static String dump(HttpServletRequest request) throws Exception {

        HashMap<String, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("url", request.getRequestURL());
        hashMap.put("method", request.getMethod());
        hashMap.put("remoteAddr", request.getRemoteAddr());
        hashMap.put("remoteHost", request.getRemoteHost());


        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Object[] cookieArray = new Object[cookies.length];
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                HashMap<String, Object> cookieMap = new HashMap<>();
                cookieMap.put("name", cookie.getName());
                cookieMap.put("value", cookie.getValue());
                cookieMap.put("maxAge", cookie.getMaxAge());
                cookieMap.put("path", cookie.getPath());
                cookieArray[i] = cookieMap;
            }
            hashMap.put("cookies", cookieArray);
        }
        Map<String, String> parameters = new HashMap<>();
        request.getParameterMap().entrySet().parallelStream().forEach(e -> {
            String valueStr = Arrays.toString(e.getValue());
            parameters.put(e.getKey(), valueStr.substring(0, Math.min(64, valueStr.length())));
        });
        hashMap.put("parameters", parameters);
        HashMap<String, Object> headerMap = new LinkedHashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            headerMap.put(name, value);
        }
        hashMap.put("headers", headerMap);
        return JSONObject.toJSONString(hashMap);
    }
}
