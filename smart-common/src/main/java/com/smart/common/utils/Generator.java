package com.smart.common.utils;


import com.smart.common.exception.ApiException;

import java.security.MessageDigest;
import java.util.UUID;


/**
 * token生成器
 * @author xiaobai
 * @date 2017/10/29 15:02
 **/
public class Generator {

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new ApiException("生成Token失败", e);
        }
    }

    public static String generateSalt() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    public static void main(String[] args){
    System.out.println(generateSalt());
    }
}
