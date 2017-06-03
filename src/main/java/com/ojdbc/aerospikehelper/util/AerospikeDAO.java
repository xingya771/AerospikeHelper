/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.util;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Host;
import com.aerospike.client.Info;
import com.aerospike.client.Key;
import com.aerospike.client.Operation;
import com.aerospike.client.Record;
import com.aerospike.client.cluster.Node;
import com.aerospike.client.policy.BatchPolicy;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.QueryPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.IndexType;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.Statement;
import com.aerospike.client.task.IndexTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Arthur
 */
public class AerospikeDAO {

    public ClientPolicy clientPolicy = new ClientPolicy();
    public List<Host> hostList = new ArrayList<>();
    private Pattern set_name_pattern = Pattern.compile("[set_name|set]=(.*?):");

    public AerospikeDAO(String ip, int port) {
        clientPolicy.timeout=20000;
        client = new AerospikeClient(clientPolicy, new Host(ip, port));

    }

    public AerospikeDAO() {
    }

    public AerospikeDAO addHost(Host... hosts) {
        Collections.addAll(hostList, hosts);
        return this;
    }

    /**
     * This client is thread-safe. One client instance should be used per
     * cluster. Multiple threads should share this cluster instance.
     */
    public static AerospikeClient client;

    public ClientPolicy getClientPolicy() {
        return clientPolicy;
    }

    public AerospikeClient getClient() {
        return client;
    }

    public List<String> getAllSetNames(String namespace) {
        List<String> list = new ArrayList<>();
        Node one_node = this.getClient().getNodes()[0];
        String setsinfo = Info.request(one_node, "sets/" + namespace);
        String[] items=setsinfo.split("ns=");
		for (int i = 0; i < items.length; i++) {
			if(items[i]==null||items[i].equals("")||items[i].length()<5){
				continue;
			}
			String[] t=items[i].substring(items[i].indexOf(":")+1).split(":");
			String setName=t[0].split("=")[1];
			String objects=t[1].split("=")[1];
                        list.add(setName+"_"+objects);
		}
       
//        Matcher m = set_name_pattern.matcher(setsinfo);
//        while (m.find()) {
//            list.add(m.group(1));
//        }
        return list;
    }

    public List<String> getAllNamespace() {
        List<String> list = new ArrayList<>();
        Node one_node = this.getClient().getNodes()[0];
        String setsInfo = Info.request(one_node, "namespaces");
        if (StringUtil.isEmpty(setsInfo)) {
            return null;
        }
        return Arrays.asList(setsInfo.split(";"));
    }
    public AerospikeDAO put(WritePolicy policy, Key key, Bin... bins) {
        if (bins == null || bins.length == 0) {
            getClient().put(policy, key);
        } else {
            getClient().put(policy, key, bins);
        }
        return this;
    }

    public AerospikeDAO put(WritePolicy policy, Key key, Map<String, Object> map) {
        return this.put(policy, key, AerospikeUtil.createBinsFromMap(map));
    }

    public AerospikeDAO put(Key key, Bin... bins) {
        return this.put(null, key, bins);
    }

    public AerospikeDAO put(Key key, Map<String, Object> map) {
        return this.put(key, AerospikeUtil.createBinsFromMap(map));
    }

    public AerospikeDAO append(WritePolicy policy, Key key, Bin... bins) {
        getClient().append(policy, key, bins);
        return this;
    }

    public AerospikeDAO append(Key key, Bin... bins) {
        return this.append(null, key, bins);
    }

    public Record getOneRecord(Key key, String... binNames) {
        return this.getOneRecord(null, key, binNames);
    }

    public Object getOneBinValue(Key key, String binName) {
        Record record = this.getOneRecord(null, key, binName);
        if (record != null && record.bins != null && record.bins.containsKey(binName)) {
            return record.bins.get(binName);
        } else {
            return null;
        }
    }

    public Record getOneRecord(Policy policy, Key key, String... binNames) {
        if (binNames == null || binNames.length == 0) {
            return getClient().get(policy, key);
        }
        return getClient().get(policy, key, binNames);

    }

    /**
     * 一次获取多个key对应的Record,包含可选的binnames列表
     *
     * @param policy BatchPolicy
     * @param keys keys
     * @param binNames
     * @return Records
     */
    public Record[] getRecords(BatchPolicy policy, Key[] keys, String... binNames) {
        if (binNames == null || binNames.length == 0) {
            return getClient().get(policy, keys);
        }
        return getClient().get(policy, keys, binNames);
    }

    /**
     * 一次获取多个key对应的Record
     *
     * @param keys keys
     * @param binNames 可选的binNames
     * @return
     */
    public Record[] getRecords(Key[] keys, String... binNames) {
        return this.getRecords(new BatchPolicy(), keys, binNames);
    }

    /**
     * 删除key对应的record,可支持多个key。
     *
     * @param policy
     * @param keys
     * @return
     */
    public AerospikeDAO delete(WritePolicy policy, Key... keys) {
        if (keys == null || keys.length == 0) {
            return this;
        }
        for (Key key : keys) {
            getClient().delete(policy, key);
        }
        return this;
    }

    public AerospikeDAO delete(Key... keys) {

        return this.delete(null, keys);
    }

    public AerospikeDAO operate(WritePolicy policy, Key key, Operation... operations) {
        getClient().operate(policy, key, operations);
        return this;
    }

    public AerospikeDAO operate(Key key, Operation... operations) {
        return this.operate(null, key, operations);
    }

    /**
     * 执行查询
     *
     * @param policy
     * @param statement 可使用AerospikeUtil.createStatement方法辅助创建
     * @return map
     */
    public Map<Key, Record> query(QueryPolicy policy, Statement statement) {
        policy.sendKey = true;
        RecordSet rs = getClient().query(policy, statement);
        Map<Key, Record> map = new HashMap<>();
        try {
            while (rs.next()) {
                Key key = rs.getKey();
                Record record = rs.getRecord();
                map.put(key, record);
            }
        } finally {
            rs.close();
        }

        return map;
    }

    /**
     * 执行查询
     *
     * @param policy
     * @param statement 可使用AerospikeUtil.createStatement方法辅助创建
     * @return map
     */
    public void query(QueryPolicy policy, Statement statement, AerospikeQueryHandler handler) {
        policy.sendKey = true;
        RecordSet rs = getClient().query(policy, statement);
        try {
            while (rs.next()) {
                handler.handler(rs.getKey(), rs.getRecord());
            }
        } finally {
            rs.close();
        }

    }
    
     /**
     * 执行查询
     *
     * @param policy
     * @param statement 可使用AerospikeUtil.createStatement方法辅助创建
     * @return map
     */
    public void query(Statement statement, AerospikeQueryHandler handler) {
        QueryPolicy policy=new QueryPolicy();
        policy.sendKey = true;
        RecordSet rs = getClient().query(policy, statement);
        try {
            while (rs.next()) {
                handler.handler(rs.getKey(), rs.getRecord());
            }
        } finally {
            rs.close();
        }

    }
    
      /**
     * 执行查询
     *
     * @param policy
     * @param statement 可使用AerospikeUtil.createStatement方法辅助创建
     * @return map
     */
    public void query(Statement statement, AerospikeQueryHandler handler,int limit) {
        QueryPolicy policy=new QueryPolicy();
        policy.sendKey = true;
        RecordSet rs = getClient().query(policy, statement);
        int count=0;
        try {
            while (rs.next()) {
                
                handler.handler(rs.getKey(), rs.getRecord());
                count+=1;
                if(count>limit){
                    break;
                }
            }
        } finally {
            rs.close();
        }

    }

    public Map<Key, Record> query(Statement statement) {
        return this.query(null, statement);
    }

    public boolean exists(Key key) {
        return this.exists(null, key);
    }

    public boolean exists(Policy policy, Key key) {
        return getClient().exists(null, key);
    }

    public void createIndex(String namespace, String set, String bin) {
        String indexName = set + "_" + bin;
        IndexTask indexTask = this.getClient().createIndex(null, namespace, set, indexName, bin, IndexType.STRING);
        indexTask.waitTillComplete();
    }

    public void deleteAllRecords(String namespace, String set) {
        this.getClient().scanAll(null, namespace, set, (Key key, Record record)
                -> getClient().delete(null, key)
        );
    }

    private int getIntFromObject(Object value) {
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Long) {
            long val = (Long) value;
            return (int) val;
        }
        return 0;
    }
}
