package com.smart.common.utils;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Protostuff序列化工具
 * 
 * @author xiaobai
 * @date 2017-06-28
 */
public class ProtostuffUtil {
    private static final Map<Class<?>, Schema<?>> CACHE_SCHEMA = new ConcurrentHashMap();

    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> clazz) {
        Schema<?> schema = CACHE_SCHEMA.get(clazz);
        if (schema == null) {
            synchronized (clazz) {
                if (schema == null) {
                    schema = RuntimeSchema.createFrom(clazz);
                    CACHE_SCHEMA.put(clazz, schema);
                }
            }
        }
        return (Schema<T>) schema;
    }

    /**
     * 序列化
     */
    public static byte[] serialize(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("序列化失败：没有找到序列化对象！！");
        }
        @SuppressWarnings("unchecked")
        Class<Object> clazz = (Class<Object>) obj.getClass();
        Schema<Object> schema = getSchema(clazz);
        LinkedBuffer buffer = LinkedBuffer.allocate();
        try {
            return ProtobufIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw new IllegalArgumentException("序列化失败：" + e.getMessage(), e);
        }
    }

    /**
     * 反序列化
     */
    public static <T> T unserialize(byte[] bs, Class<T> clazz) {
        if (bs == null || bs.length == 0) {
            throw new IllegalArgumentException("反序列化失败：没有找到反序列化数据！");
        }
        Schema<T> schema = getSchema(clazz);
        T instance = schema.newMessage();
        ProtobufIOUtil.mergeFrom(bs, instance, schema);
        return instance;
    }
}
