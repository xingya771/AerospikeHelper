/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.util;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Arthur
 */
public class StringUtil {

    /**
     * 判断给定类型是否为空,支持字符串,数组,List,Set,Map
     *
     * @param objs 要判断的对象
     * @return 对象为null或者size=0
     */
    public static boolean isEmpty(Object... objs) {
        if (objs == null || objs.length == 0) {
            return true;
        }
        for (Object obj : objs) {
            if (obj == null) {
                return true;
            }
            if (obj instanceof String && "".equals(obj)) {
                return true;
            }
            if (obj instanceof List && ((List) obj).size() == 0) {
                return true;
            }
            if (obj instanceof Set && ((Set) obj).size() == 0) {
                return true;
            }
            if (obj instanceof Map && ((Map) obj).size() == 0) {
                return true;
            }

        }
        return false;
    }

    public static Map<String, String> parseWhere(String command) {
        int index = command.toLowerCase().indexOf("where");
        if (index == -1) {
            return null;
        }
        command = command.substring(index + 5);
        command = command.trim();
        String[] items = command.split("(?i)and");
        Map<String, String> wheres = new HashMap<>();
        for (String item : items) {
            if (item.contains("=")) {
                String keyvalue[] = item.split("=");
                wheres.put(keyvalue[0].trim(), keyvalue[1].trim().replace("\"", "").replace("'", ""));
            } else if (item.contains("rownum in ")) {
                item = item.replace("rownum in", "").replace("(", "").replace(")", "");
                wheres.put("rownum_begin", item.split(",")[0].trim());
                wheres.put("rownum_end", item.split(",")[1].trim());
            }

        }
        return wheres;

    }

    public static String jsonFormatter(String uglyJSONString) {
        String res = null;
        try {
            res = new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser().parse(uglyJSONString));
            if (res.startsWith("\"")) {
                if (res.endsWith("\"")) {
                    res = res.substring(1, res.length() - 1);
                } else {
                    res = res.substring(1);
                }

            }
        } catch (Exception e) {
            res = uglyJSONString;
        }
        return res;
    }
}
