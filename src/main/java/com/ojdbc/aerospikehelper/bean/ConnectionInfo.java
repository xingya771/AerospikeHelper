/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Arthur
 */
public class ConnectionInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private String ip;
    private int port;
    private List<ConnectionInfo_namespace> namespaces; 

    public ConnectionInfo() {
    }

    public ConnectionInfo(String name, String ip, int port) {
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.namespaces = new ArrayList<>();
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

    public List<ConnectionInfo_namespace> getNamespaces() {
        return namespaces;
    }

    public void setNamespaces(List<ConnectionInfo_namespace> namespaces) {
        this.namespaces = namespaces;
    }

    @Override
    public String toString() {
        return  name+"["+ip+":"+ port+"]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConnectionInfo other = (ConnectionInfo) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}
