/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.ui;

import com.ojdbc.aerospikehelper.util.UIUtil;

/**
 *
 * @author Arthur
 */
public class ShowDetailDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form showDetailDialog
     */
    public ShowDetailDialog(java.awt.Frame parent, boolean modal,String value) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        UIUtil.setKeyMask(valueJTA);
        this.valueJTA.setText(value);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        valueJTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        valueJTA.setColumns(20);
        valueJTA.setLineWrap(true);
        valueJTA.setRows(5);
        valueJTA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valueJTAFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(valueJTA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valueJTAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valueJTAFocusGained
        valueJTA.selectAll();
    }//GEN-LAST:event_valueJTAFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea valueJTA;
    // End of variables declaration//GEN-END:variables
}
