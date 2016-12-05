/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.bean;

import java.util.Map;

/**
 *
 * @author Arthur
 */
public class AerospikeRow {
    private String PK;
    private Map<String,Object> bins;

    public AerospikeRow(String PK, Map<String, Object> bins) {
        this.PK = PK;
        this.bins = bins;
    }

    public String getPK() {
        return PK;
    }

    public void setPK(String PK) {
        this.PK = PK;
    }

    public Map<String,Object> getBins() {
        return bins;
    }

    public void setBins(Map<String,Object> bins) {
        this.bins = bins;
    }
    
}
