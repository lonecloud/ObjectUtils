package cn.lonelcoud.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lonecloud on 17/3/12.
 * 用于对Object进行解析并且转换成Map键值对的形式
 * @author lonecloud
 * @version 1.0
 */
public class ObjectUtils {


    /**
     * 获取利用反射获取类里面的值和名称
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String,Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String,Object> map=new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName,value);
        }
        return map;
    }
}
