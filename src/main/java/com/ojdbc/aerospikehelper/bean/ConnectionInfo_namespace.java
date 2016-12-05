/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class ConnectionInfo_namespace implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private String ip;
    private int port;
    private String namespace;
    private List<ConnectionInfo_set> sets;
    public ConnectionInfo_namespace(String name, String ip, int port, String namespace) {
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.namespace = namespace;
        this.sets=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @Override
    public String toString() {
        return this.namespace;
    }

    public List<ConnectionInfo_set> getSets() {
        return sets;
    }

    public void setSets(List<ConnectionInfo_set> sets) {
        this.sets = sets;
    }

}
