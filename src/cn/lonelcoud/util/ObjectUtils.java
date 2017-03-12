package cn.lonelcoud.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lonecloud on 17/3/12.
 * 用于对Object进行解析并且转换成Map键值对的形式
 *
 * @author lonecloud
 * @version 1.0
 */
public class ObjectUtils {

    private static final String JAVAP="java.";
    private static final String JAVADATESTR="java.util.Date";

    /**
     * 获取利用反射获取类里面的值和名称
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        System.out.println(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }

    /**
     * 利用递归调用将Object中的值全部进行获取
     * @param obj map
     * @param param 第一个为时间格式化参数 默认<strong>2017-03-10 10:21</strong>
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, String> objectToMapString(Object obj,String... param) throws IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        objectTransfer(obj,map,param);
        return map;
    }

    /**
     * 递归调用函数
     * @param obj 对象
     * @param map map
     * @param param 对应参数
     * @return
     * @throws IllegalAccessException
     */
    private static Map<String, String> objectTransfer(Object obj, Map<String, String> map,String... param) throws IllegalAccessException {
        String formatStr="YYYY-MM-dd HH:mm:ss";
        if (param.length!=0){
            formatStr=param[0];
        }
        Class<?> clazz = obj.getClass();
        //获取值
        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = clazz.getSimpleName()+"."+field.getName();
            field.setAccessible(true);
            Object value = field.get(obj);
            Class<?> valueClass = value.getClass();
            if (valueClass.isPrimitive()){
                map.put(fieldName,value.toString());

            }else if (valueClass.getName().contains(JAVAP)){//判断是不是基本类型
                if (valueClass.getName().equals(JAVADATESTR)){
                    //格式化Date类型
                    SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
                    Date date=(Date) value;
                    String dataStr = sdf.format(date);
                    map.put(fieldName,dataStr);
                }else{
                    map.put(fieldName,value.toString());
                }
            }else{
                objectTransfer(value,map);
            }
        }
        return map;
    }

}
