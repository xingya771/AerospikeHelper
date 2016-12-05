/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author Arthur
 */
public class StackUtil {

    public static String getStackTrace(Throwable e) {
        try (ByteArrayOutputStream buf = new java.io.ByteArrayOutputStream()) {
            e.printStackTrace(new java.io.PrintWriter(buf, true));
            String expMessage = buf.toString();
            return expMessage;
        } catch (IOException ex) {

        }
        return "";
    }
}
