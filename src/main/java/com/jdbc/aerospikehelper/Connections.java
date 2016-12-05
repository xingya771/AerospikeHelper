/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc.aerospikehelper;

import com.ojdbc.aerospikehelper.bean.ConnectionInfo;
import com.ojdbc.aerospikehelper.bean.ConnectionInfo_namespace;
import com.ojdbc.aerospikehelper.util.AerospikeDAO;
import com.ojdbc.aerospikehelper.util.LRUCache;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class Connections {
    public static LRUCache<String,ConnectionInfo> allConnections=new LRUCache<>(1000);
    public static List<ConnectionInfo> all=new ArrayList<>();
    public static List<String> getNameSpaces(ConnectionInfo info){
        AerospikeDAO dao=new AerospikeDAO(info.getIp(), info.getPort());
        return dao.getAllNamespace();
    }
    
     public static List<String> getSets(ConnectionInfo_namespace info){
        AerospikeDAO dao=new AerospikeDAO(info.getIp(), info.getPort());
        return dao.getAllSetNames(info.getNamespace());
    }
}
