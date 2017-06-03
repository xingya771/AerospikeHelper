/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.bean;

import java.io.Serializable;

/**
 *
 * @author Arthur
 */
public class ConnectionInfo_set implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String ip;
    private int port;
    private String namespace;
    private String setName;
    private String objects;

    public ConnectionInfo_set(String name, String ip, int port, String namespace, String setName,String objects) {
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.namespace = namespace;
        this.setName = setName;
        this.objects = objects;
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

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getObjects() {
        return objects;
    }

    public void setObjects(String objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return this.setName+"["+this.objects+"]";
    }

}
