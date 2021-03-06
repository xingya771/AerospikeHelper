/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.aerospikehelper.ui;

import com.ojdbc.aerospikehelper.util.UIUtil;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Arthur
 */
public class ConnectDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form ConnectDialog
     * @param parent
     * @param modal
     */
    public ConnectDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        UIUtil.setKeyMask(ipJTF);
        UIUtil.setKeyMask(nameJTF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ipJTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        portJSP = new javax.swing.JSpinner();
        cancelJBT = new javax.swing.JButton();
        okJBT = new javax.swing.JButton();
        nameJTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add connection");

        jLabel1.setText("ip");

        ipJTF.setText("127.0.0.1");
        ipJTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ipJTFFocusGained(evt);
            }
        });

        jLabel2.setText("port");

        portJSP.setValue(3000);

        cancelJBT.setText("cancel");
        cancelJBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelJBTMouseReleased(evt);
            }
        });

        okJBT.setText("ok");

        nameJTF.setText("db1");

        jLabel3.setText("name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(portJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(okJBT)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ipJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                        .addComponent(nameJTF))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cancelJBT)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ipJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(portJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelJBT)
                    .addComponent(okJBT))
                .addGap(50, 50, 50))
        );

        portJSP.setValue(3000);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelJBTMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelJBTMouseReleased
        this.setVisible(false);
    }//GEN-LAST:event_cancelJBTMouseReleased

    private void ipJTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ipJTFFocusGained
      ipJTF.selectAll();
    }//GEN-LAST:event_ipJTFFocusGained


    public JButton getCancelJBT() {
        return cancelJBT;
    }

    public void setCancelJBT(JButton cancelJBT) {
        this.cancelJBT = cancelJBT;
    }

    public JButton getOkJBT() {
        return okJBT;
    }

    public void setOkJBT(JButton okJBT) {
        this.okJBT = okJBT;
    }

    public JTextField getIpJTF() {
        return ipJTF;
    }

    public void setIpJTF(JTextField ipJTF) {
        this.ipJTF = ipJTF;
    }

    public JSpinner getPortJSP() {
        return portJSP;
    }

    public void setPortJSP(JSpinner portJSP) {
        this.portJSP = portJSP;
    }

    public JTextField getNameJTF() {
        return nameJTF;
    }

    public void setNameJTF(JTextField nameJTF) {
        this.nameJTF = nameJTF;
    }
    public String ip;
    public int port;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelJBT;
    private javax.swing.JTextField ipJTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nameJTF;
    private javax.swing.JButton okJBT;
    private javax.swing.JSpinner portJSP;
    // End of variables declaration//GEN-END:variables
}
