/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.camila.pe.cpresentacion;
import com.camila.pe.cmodelo.Cliente;
import com.camila.pe.cnegocio.ClienteBO;
import com.camila.pe.cmodelo.Billete;
import com.camila.pe.cmodelo.Compañia;
import com.camila.pe.cnegocio.BilleteBO;
import com.camila.pe.cnegocio.CompañiaBO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class JPBillete extends javax.swing.JPanel {
    BilleteBO btbo = new  BilleteBO();
    Billete b = new Billete();
    CompañiaBO cpbo = new CompañiaBO();
    Compañia cp = new Compañia();
    
    String billete;
     
    public JPBillete() {
        
        initComponents();
        listarClienteCombo();
        listarCompañiaCombo();
    }
    
    private void listarClienteCombo(){
        ClienteBO tdbo =new ClienteBO();
        
        for(Cliente item : tdbo.listarClienteCombo()){
            jccliente.addItem(item.getDNI());
        }
    
    
    }
   private void listarCompañiaCombo(){
       CompañiaBO cpbo =new CompañiaBO();
        
        for(Compañia item : cpbo.listarCompañiaCombo()){
            jccompañia.addItem(item.getNro_compañia());
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        txthora = new javax.swing.JTextField();
        txtorigen = new javax.swing.JTextField();
        txtdestino = new javax.swing.JTextField();
        txtitinerario = new javax.swing.JTextField();
        txtbillete = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jccliente = new javax.swing.JComboBox<>();
        jccompañia = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE BILLETE");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 342, 59));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NRO_BILLETE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 143, 33));

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 143, 33));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("HORA");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 143, 33));

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ORIGEN");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 143, 33));

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FECHA");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 143, 33));

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ITINENARIO");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 143, 33));

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NRO_COMPAÑIA");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 143, 33));

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DESTINO");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 143, 33));

        txtfecha.setBorder(null);
        add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 244, 39));

        txthora.setBorder(null);
        add(txthora, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 244, 39));

        txtorigen.setBorder(null);
        add(txtorigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 244, 39));

        txtdestino.setBorder(null);
        add(txtdestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 244, 39));

        txtitinerario.setBorder(null);
        add(txtitinerario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 244, 39));

        txtbillete.setBorder(null);
        add(txtbillete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 244, 39));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 104, 38));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 104, 40));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, 104, 40));

        jccliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcclienteActionPerformed(evt);
            }
        });
        add(jccliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 250, 40));

        jccompañia.setBorder(null);
        jccompañia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jccompañiaActionPerformed(evt);
            }
        });
        add(jccompañia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 250, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/camila/pe/cpresentacion/COMPAÑIA.png"))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jcclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcclienteActionPerformed
    }//GEN-LAST:event_jcclienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   try {
            b.setNro_billete(txtbillete.getText());
            b.setFecha(txtfecha.getText());
            b.setHora(txthora.getText());            
            b.setDestino(txtdestino.getText());
            b.setOrigen(txtorigen.getText());
            b.setItinerario(txtitinerario.getText());
            b.setDNI((String) jccliente.getSelectedItem());
            b.setNro_compañia((String) jccompañia.getSelectedItem());


           // cp.getNro_compañia()
            btbo.agregarBillete(b);

            JOptionPane.showMessageDialog(null, ":) se guardo corectamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: al guardar Tipo documento ");
        }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jccompañiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jccompañiaActionPerformed

    }//GEN-LAST:event_jccompañiaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      txtbillete.setText("");
      txtfecha.setText("");
      txthora.setText("");
      txtdestino.setText("");
      txtorigen.setText("");

        JOptionPane.showMessageDialog(null, "Campos limpiados.");    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jccliente;
    private javax.swing.JComboBox<String> jccompañia;
    private javax.swing.JTextField txtbillete;
    private javax.swing.JTextField txtdestino;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txthora;
    private javax.swing.JTextField txtitinerario;
    private javax.swing.JTextField txtorigen;
    // End of variables declaration//GEN-END:variables
}
