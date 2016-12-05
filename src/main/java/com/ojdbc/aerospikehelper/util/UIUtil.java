/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.util;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Arthur
 */
public class UIUtil {
    public static void setKeyMask(JTextComponent jtf) {
        int MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, MASK), "select-all");
        jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, MASK), "copy");
        jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_X, MASK), "cut");
        jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, MASK), "paste");
    }
}
