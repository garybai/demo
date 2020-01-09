package com.example.unnameddemo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 反射测试
 *
 * @author Gary
 * @date 2019/12/25 14:56
 * @since jdk1.8
 **/
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.example.unnameddemo.reflection.Student");
        Method method = clazz.getMethod("doHomework", String.class);
        Constructor constructor = clazz.getConstructor();
        Object object = constructor.newInstance();
        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        fields.forEach(field -> field.setAccessible(true));
        Map<String, Object> map = new HashMap<>(2);
        map.put("age", 11);
        map.put("name", "bbb");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            for (Field field : fields) {
                if (field.getName().equalsIgnoreCase(key)){
                    field.set(object, map.get(key));
                    break;
                }
            }
        }
//        keys.forEach(k -> {
//            fields.forEach(field -> {
//                if (field.getName().equalsIgnoreCase(k)) {
//                    try {
//                        field.set(object, map.get(k));
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        });
        method.invoke(object, "数学");
    }
}
