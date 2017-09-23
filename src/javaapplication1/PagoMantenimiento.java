/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author rodol
 */
public class PagoMantenimiento extends javax.swing.JFrame {

    /**
     * Creates new form PagoMantenimiento
     */
    public PagoMantenimiento() {
        try {
            initComponents();
            show_Pago();
        } catch (SQLException ex) {
            Logger.getLogger(PagoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Pago>PagoList() throws SQLException
{
    ArrayList<Pago>PagoList = new ArrayList<Pago>();
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1998naciojose");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM \"public\".vw_pago LIMIT 100;");
    Pago pago;
    while(rs.next()){
       pago=new Pago(
               rs.getDate("FECHA"),
               rs.getInt("MONTO"),
               rs.getInt("INTERESES"),
               rs.getInt("CAPITAL"),
               rs.getDate("FECHA_CREACION"),
               rs.getString("USUARIO_CREADOR"),rs.getInt("pagos_prestamos"),rs.getInt("NUM_PAGO"));
       PagoList.add(pago);
    }
    return PagoList;
}
    
    public void show_Pago() throws SQLException{
    ArrayList<Pago> list = PagoList();
    DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
    Object[] row = new Object[12];
    for(int i=0 ;i<list.size();i++){
        row[0]=list.get(i).getFecha();
        row[1]=list.get(i).getMonto();
        row[2]=list.get(i).getIntereses();
        row[3]=list.get(i).getCapital();
        row[4]=list.get(i).getFecha_creacion();
        row[5]=list.get(i).getUsuario_creador();
        row[6]=list.get(i).getPagos_prestamos();
        row[7]=list.get(i).getNum_pago();
        model.addRow(row);
    }
    }
    
    public void close(){
    WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("PAGO");

        jLabel2.setText("FECHA");

        jLabel3.setText("MONTO");

        jLabel4.setText("INTERESES");

        jLabel5.setText("CAPITAL");

        jLabel6.setText("ID PRESTAMOS");

        jLabel7.setText("NUMERO PAGO");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "MONTO", "INTERESES", "CAPITAL", "FECHA_CREACION", "USUARIO_CREADOR", "ID_PRESTAMOS", "NUM_PAGO"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/update.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/delete.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/create.jpg"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("BACK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1386, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try {    
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1998naciojose");
            Statement st = conn.createStatement();  
        
CallableStatement ps = conn.prepareCall("{ call fn_update_pago(?,?,?,?,?,?) }");
                java.util.Date date =  new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(jTextField1.getText());
                java.sql.Date timestamp = new java.sql.Date(date.getTime());
                ps.setDate(1,timestamp);
                ps.setInt(2,(int) Double.parseDouble(jTextField2.getText()));
                 ps.setInt(3,(int) Double.parseDouble(jTextField3.getText()));
                ps.setInt(4,(int) Double.parseDouble(jTextField4.getText()));
                 ps.setInt(5,(int) Double.parseDouble(jTextField5.getText()));
                ps.setInt(6,(int) Double.parseDouble(jTextField6.getText()));
                
                
                ps.execute();
                ps.close();
                
               
                
                DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                show_Pago();
            } catch (SQLException ex) {
            Logger.getLogger(ProyectoFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
            Logger.getLogger(AbonoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1998naciojose");
            CallableStatement ps = conn.prepareCall("{ call fn_delete_pago(?) }");
            ps.setInt(1,(int) Double.parseDouble(jTextField6.getText()));
            ps.execute();
            ps.close();
            DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);     
            show_Pago();
        } catch (SQLException ex) {
            Logger.getLogger(AbonoMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            int flag=1;
            long org;
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1998naciojose");
            Statement st = conn.createStatement();
            ResultSet Empleado = st.executeQuery("SELECT * FROM \"public\".vw_prestamo LIMIT 100;");
            CallableStatement upperProc = conn.prepareCall("{? = call fn_pago_periodo_especifico( ? ) }");
                upperProc.registerOutParameter(1, Types.BIGINT);
                upperProc.setInt(2, (int) Double.parseDouble(jTextField5.getText()));
                upperProc.execute();
                long esp=upperProc.getLong(1);
                System.out.print(esp);
                upperProc.close();
             CallableStatement Proc = conn.prepareCall("{? = call fn_pago_periodo( ? ) }");
                Proc.registerOutParameter(1, Types.BIGINT);
                Proc.setInt(2, (int) Double.parseDouble(jTextField5.getText()));
                Proc.execute();
                org=Proc.getLong(1);
                System.out.print(org);
                
            while(Empleado.next())
            {
                if(!Empleado.getString(9).equals(jTextField6.getText()) )
                {
                    flag=0;
                    break;
                }

            }
            if(flag==0){
                if(esp<org){
                    long pmts;
                    long ipmts;
                    long ppmts;
                    Usuario_creador u = new Usuario_creador();
                    String usuario=u.getUsuario();
                CallableStatement pmt = conn.prepareCall("{? =  call fn_pmt(?) }");
                pmt.registerOutParameter(1, Types.BIGINT);
                pmt.setInt(2, (int) Double.parseDouble(jTextField5.getText()));
                pmt.execute();
                pmts=pmt.getLong(1);
                pmt.close();
                CallableStatement ppmt = conn.prepareCall("{? =  call fn_ppmt(?,?,?) }");
                ppmt.registerOutParameter(1, Types.BIGINT);
                ppmt.setString(2, usuario);
                ppmt.setInt(3, (int) Double.parseDouble(jTextField5.getText()));
                ppmt.setInt(4, (int)esp);
                ppmt.execute();
                ppmts=ppmt.getLong(1);
                ppmt.close();
                CallableStatement ipmt = conn.prepareCall("{? =  call fn_ipmt2(?,?) }");
                ipmt.registerOutParameter(1, Types.BIGINT);
                ipmt.setInt(2, (int) pmts);
                ipmt.setInt(3, (int) ppmts);
                ipmt.execute();
                ipmts=ipmt.getLong(1);
                ipmt.close();
                jLabel8.setText("Prestamo CREADO");
                 CallableStatement ps = conn.prepareCall("{ call fn_create_pago(CURRENT_DATE,?,?,?,?,?) }");
                 ps.setInt(1,(int)pmts);
                 ps.setInt(2,(int)ppmts);
                 ps.setInt(3,(int)ipmts);
                  ps.setString(4,usuario);
                  ps.setInt(5,(int) Double.parseDouble(jTextField5.getText()));
                /* CallableStatement ps = conn.prepareCall("{ call fn_pagos_crear_bien(?,?,?) }");
                 Usuario_creador u = new Usuario_creador();
                String usuario=u.getUsuario();
                  ps.setString(1,usuario);
                   ps.setInt(2,(int) Double.parseDouble(jTextField5.getText()));
                   ps.setInt(3,(int) Double.parseDouble(jTextField7.getText()));
                 */
                /*java.util.Date date =  new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(jTextField1.getText());
                java.sql.Date timestamp = new java.sql.Date(date.getTime());
                ps.setDate(1,timestamp);
                ps.setInt(2,(int) Double.parseDouble(jTextField2.getText()));
                 ps.setInt(3,(int) Double.parseDouble(jTextField3.getText()));
                 ps.setInt(4,(int) Double.parseDouble(jTextField4.getText()));
                 Usuario_creador u = new Usuario_creador();
                String usuario=u.getUsuario();
                  ps.setString(5,usuario);
                 ps.setInt(6,(int) Double.parseDouble(jTextField5.getText()));
                */
                ps.execute();
                ps.close();
                DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                show_Pago();
                }else{
                    jLabel8.setText("Prestamo Pagado");
                }
            }
            else{
                jLabel8.setText("Prestamo NO CREADO");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoFrame.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Mantenimiento m = new Mantenimiento();
        m.setVisible(true);
        close();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        jTextField1.setText(model.getValueAt(i, 0).toString());
        jTextField2.setText(model.getValueAt(i, 1).toString());
        jTextField3.setText(model.getValueAt(i, 2).toString());
        jTextField4.setText(model.getValueAt(i, 3).toString());
        jTextField5.setText(model.getValueAt(i, 6).toString());
        jTextField6.setText(model.getValueAt(i, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PagoMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagoMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagoMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagoMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagoMantenimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
