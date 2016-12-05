/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.util;

import com.aerospike.client.Key;
import com.aerospike.client.Record;

/**
 *
 * @author Arthur
 */
public interface AerospikeQueryHandler {

    void handler(Key key, Record record);
}
