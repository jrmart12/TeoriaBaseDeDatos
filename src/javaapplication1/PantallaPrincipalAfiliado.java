/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class PantallaPrincipalAfiliado extends javax.swing.JFrame {
idEMP id= new idEMP();
    /**
     * Creates new form PantallaPrincipalAfiliado
     */
    public PantallaPrincipalAfiliado() {
    try {
        initComponents();
        show_Empleado();
        show_Cuenta();
        show_Prestamo();
        show_Pago();
        show_Abono();
    } catch (SQLException ex) {
        Logger.getLogger(PantallaPrincipalAfiliado.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public ArrayList<Abono>AbonoList() throws SQLException
{
    ArrayList<Abono>AbonoList = new ArrayList<Abono>();
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1998naciojose");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * from abono_reporte('"+id.getId()+"');");
    Abono abono;
    while(rs.next()){
       abono=new Abono(rs.getInt("MONTO"),
               rs.getDate("FECHA"),
               rs.getString("COMENTARIO"),
               rs.getDate("FECHA_CREACION"),
               rs.getString("USUARIO_CREADOR"),rs.getInt("ABONO_CUENTA"),rs.getInt("ID_ABONO"),rs.getInt("ID_CUENTA"));
       AbonoList.add(abono);
    }
    return AbonoList;
}

public void show_Abono() throws SQLException{
    ArrayList<Abono> list = AbonoList();
    DefaultTableModel model= (DefaultTableModel)jTable5.getModel();
    Object[] row = new Object[12];
    for(int i=0 ;i<list.size();i++){
        row[0]=list.get(i).getMonto();
        row[1]=list.get(i).getFecha();
        row[2]=list.get(i).getComentario();
        row[3]=list.get(i).getFecha_creacion();
        row[4]=list.get(i).getUsuario_creador();
        row[5]=list.get(i).getAbono_cuenta();
        row[6]=list.get(i).getId_abono();
        row[7]=list.get(i).getId_cuenta();
        model.addRow(row);
    }
}
    
       public ArrayList<Pago>PagoList() throws SQLException
{
    ArrayList<Pago>PagoList = new ArrayList<Pago>();
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1998naciojose");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * from pago_reporte('"+id.getId()+"');");
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
    DefaultTableModel model= (DefaultTableModel)jTable4.getModel();
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
    
 public ArrayList<Empleado>EmpleadoList() throws SQLException
{
    ArrayList<Empleado>EmpleadosList = new ArrayList<Empleado>();
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1998naciojose");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM empleado_reporte('"+id.getId()+"');");
    Empleado empleado;
    while(rs.next()){
        empleado=new Empleado(rs.getString("ID_CODIGO"),rs.getString("NOMBRE_EMP"),rs.getInt("TELEFONO_EMP"),rs.getString("DIRECCION_EMP"),rs.getString("CORREO_EMP"),rs.getString("NACIMIENTO"),rs.getDate("FECHA_INICIO"),rs.getDate("ANTIGUEDAD"),rs.getDate("FECHA_CREACION"),rs.getDate("ULTIMA_MODIFICACION"),rs.getString("USUARIO_CREADOR"),rs.getString("USUARIO_MODIFICADOR"));
        EmpleadosList.add(empleado);
    }
    return EmpleadosList;
}

public void show_Empleado() throws SQLException{
    ArrayList<Empleado> list = EmpleadoList();
    DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
    Object[] row = new Object[12];
    for(int i=0 ;i<list.size();i++){
        row[0]=list.get(i).getId_codigo();
        row[1]=list.get(i).getNombre_emp();
        row[2]=list.get(i).getTelefono_emp();
        row[3]=list.get(i).getDireccion_emp();
        row[4]=list.get(i).getCorreo_emp();
        row[5]=list.get(i).getNacimiento_emp();
        row[6]=list.get(i).getFecha_inicio();
        row[7]=list.get(i).getAntiguedad();
        row[8]=list.get(i).getFecha_creacion();
        row[9]=list.get(i).getFecha_modificacion();
        row[10]=list.get(i).getUsuario_creador();
        row[11]=list.get(i).getUsuario_modificador();
        model.addRow(row);
    }
}

public ArrayList<Cuenta>CuentaList() throws SQLException
{
    ArrayList<Cuenta>CuentaList = new ArrayList<Cuenta>();
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1998naciojose");
    Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery("SELECT * from cuentas_reporte('"+id.getId()+"');");
    Cuenta cuenta;
    while(rs.next()){
       cuenta=new Cuenta(rs.getInt("NUM_CUENTA"),
               rs.getDate("FECHA_APERTURA"),
               rs.getInt("SALDO"),
               rs.getString("ANTIGUEDAD"),
               rs.getString("TIPO"),
               rs.getDate("FECHA_CREACION"),
               rs.getDate("ULTIMA_MODIFICACION"),
               rs.getString("USUARIO_CREADOR"),
               rs.getString("USUARIO_MODIFICADOR"),rs.getInt("ABONO_MENSUAL"),rs.getString("CUENTAS_EMPLEADO"));
       CuentaList.add(cuenta);
    }
    return CuentaList;
}

public void show_Cuenta() throws SQLException{
    ArrayList<Cuenta> list = CuentaList();
    DefaultTableModel model= (DefaultTableModel)jTable2.getModel();
    Object[] row = new Object[12];
    for(int i=0 ;i<list.size();i++){
        row[0]=list.get(i).getNum_cuenta();
        row[1]=list.get(i).getFecha_apertura();
        row[2]=list.get(i).getSaldo();
        row[3]=list.get(i).getAntiguedad();
        row[4]=list.get(i).getTipo();
        row[5]=list.get(i).getFecha_creacion();
        row[6]=list.get(i).getUltima_modificacion();
        row[7]=list.get(i).getUsuario_creador();
        row[8]=list.get(i).getUsuario_modificador();
        row[9]=list.get(i).getAbono_mensual();
        row[10]=list.get(i).getCuentas_empleado();
        model.addRow(row);
    }
}

public ArrayList<Prestamo>PrestamoList() throws SQLException
{
    ArrayList<Prestamo>PrestamoList = new ArrayList<Prestamo>();
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1998naciojose");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * from prestamo_reporte('"+id.getId()+"');");
    Prestamo prestamo;
    while(rs.next()){
       prestamo=new Prestamo(rs.getInt("NUM_PRESTAMO"),
               rs.getDate("FECHA"),
               rs.getInt("MONTO"),
               rs.getInt("PERIDOS"),
               rs.getInt("SALDO"),
               rs.getString("TIPO_PRESTAMO"),
               rs.getDate("FECHA_CREACION"),
               rs.getString("USUARIO_CREADOR"),rs.getString("prestamos_empleado"));
       PrestamoList.add(prestamo);
    }
    return PrestamoList;
}
    public void show_Prestamo() throws SQLException{
    ArrayList<Prestamo> list = PrestamoList();
    DefaultTableModel model= (DefaultTableModel)jTable3.getModel();
    Object[] row = new Object[12];
    for(int i=0 ;i<list.size();i++){
        row[0]=list.get(i).getNum_prestamo();
        row[1]=list.get(i).getFecha();
        row[2]=list.get(i).getMonto();
        row[3]=list.get(i).getPeriodos();
        row[4]=list.get(i).getSaldo();
        row[5]=list.get(i).getTipo_prestamo();
        row[6]=list.get(i).getFecha_creacion();
        row[7]=list.get(i).getUsuario_creador();
        row[8]=list.get(i).getPrestamos_empleado();
        model.addRow(row);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("PANTALLA PRINCIPAL");

        jLabel2.setText("AFILIADO");

        jLabel3.setText("INFORMACION");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_CODIGO", "NOMBRE_EMP", "TELEFONO_EMP", "DIRECCION_EMP", "CORREO_EMP", "NACIMIENTO_EMP", "FECHA_INICO", "ANTIGUEDAD", "FECHA_CREACION", "ULTIMA_MODIFICACION", "USUARIO_CREADOR", "USUARIO_MODIFICADOR"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel4.setText("CUENTAS");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUM_CUENTA", "FECHA_APERTURA", "SALDO", "ANTIGUEDAD", "TIPO", "FECHA_CREACION", "ULTIMA_MODIFICACION", "USUARIO_CREADOR", "USUARIO_MENSUAL", "ABONO_MENSUAL", "CUENTAS_EMPLEADO"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jLabel5.setText("PRESTAMOS");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUM_PRESTAMO", "FECHA", "MONTO", "PERIODOS", "SALDO", "TIPO_PRESTAMO", "FECHA_CREACION", "USUARIO_CREADOR", "PRESTAMO_EMPEADO"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel6.setText("PAGOS");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "MONTO", "INTERESES", "CAPITAL", "FECHA_CREACION", "USUARIO_CREADOR", "ID_PRESTAMOS", "NUM_PAGO"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel7.setText("ABONOS");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MONTO", "FECHA", "COMENTARIO", "FECHA_CREACION", "USUARIO_CREADOR", "ABONO_CUENTA", "ID_ABONO", "ID_CUENTA"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1378, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked

    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked


    }//GEN-LAST:event_jTable5MouseClicked

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
            java.util.logging.Logger.getLogger(PantallaPrincipalAfiliado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipalAfiliado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipalAfiliado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipalAfiliado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipalAfiliado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    // End of variables declaration//GEN-END:variables
}
