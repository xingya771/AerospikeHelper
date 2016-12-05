/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.util;

import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.query.Filter;
import com.aerospike.client.query.Statement;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Arthur
 */
public class AerospikeUtil {
    /**
     * 根据给定namespace,setName和Keys创建Key数组,
     *
     * @param namespace namespace
     * @param setName   setName
     * @param keysList  setName
     * @return keys数组
     */
    public static Key[] createKeys(String namespace, String setName, List<String> keysList) {
        Key[] keys = new Key[keysList.size()];
        for (int i = 0, j = keysList.size(); i < j; i++) {
            keys[i] = new Key(namespace, setName, keysList.get(i));
        }
        return keys;
    }

    /**
     * 从Map创建Bin数组
     *
     * @param map bin的数据来源
     * @return 转换后的Bin数组
     */
    public static Bin[] createBinsFromMap(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return new Bin[0];
        }
        Bin[] bins = new Bin[map.size()];
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            bins[i] = new Bin(entry.getKey(), entry.getValue());
            i++;
        }
        return bins;
    }

    /**
     * 从Map创建Bin数组
     *
     * @param map bin的数据来源
     * @return 转换后的Bin数组
     */
    public static Object[] getBinsValuesFromMap(Map<String, Object> map,String binName) {
        if (map == null || map.size() == 0) {
            return new String[0];
        }
        Object[] bins = new Object[map.size()];
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            bins[i] =entry.getValue();
            i++;
        }
        return bins;
    }
    /**
     * 扩容数组并将给定值添加到扩容后的数组后
     */
    public static <T> T[] concat(T first, T[] second) {
        T[] result = Arrays.copyOf(second, second.length + 1);
        result[result.length - 1] = first;
        return result;

    }

    public static Statement createStatement(String namespace, String setName, String[] binNames,
                                            Filter... filters) {
        Statement statement = new Statement();
        statement.setNamespace(namespace);
        if(binNames!=null){
            statement.setBinNames(binNames);
        }
        if (filters != null) {
            statement.setFilters(filters);
        }
        statement.setSetName(setName);
        return statement;
    }

    /**
     * 将不定长参数转成数组,以便在方法中达到使用多个不定长参数的目的
     * @param <T>
     * @param t
     * @return
     */
    public static <T extends Object> T[] varargs2Array(T... t) {
        return t;
    }

    /**
     * 根据给定的map填充bean,可用于将Aerospike Record值赋给bean
     * @param t
     * @param map
     * @param <T>
     * @return
     */
    public static <T extends Object> T fillBeanWithMap(T t, Map<String,Object> map){
        Class c=t.getClass();
        Field[] fields = c.getDeclaredFields();
        for(Field field:fields){
            String name=field.getName();
            if(map.containsKey(name)){
                try {
                    PropertyDescriptor pd = new PropertyDescriptor(name,c);
                    Method method = pd.getWriteMethod();
                    method.invoke(t,map.get(name));
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        return t;
    }
}
