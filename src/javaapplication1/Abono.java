/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Date;

/**
 *
 * @author rodol
 */
public class Abono {

    Abono(int aInt, java.sql.Date date, int aInt0, String string, String string0, java.sql.Date date0, java.sql.Date date1, String string1, String string2, int aInt1, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getMonto() {
        return monto;
    }

    public int getAbono_cuenta() {
        return abono_cuenta;
    }

    public int getId_abono() {
        return id_abono;
    }

    public String getComentario() {
        return comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }
    int monto,abono_cuenta,id_abono,id_cuenta;

    public int getId_cuenta() {
        return id_cuenta;
    }
    String comentario,usuario_creador;
    java.util.Date fecha,fecha_creacion;
    
    public Abono(int monto,java.util.Date fecha,String comentario,java.util.Date fecha_creacion,String usuario_creador,int abono_cuenta,int id_abono,int id_cuenta){
        this.monto=monto;
        this.id_abono=id_abono;
        this.comentario=comentario;
        this.fecha=fecha;
        this.abono_cuenta=abono_cuenta;
        this.fecha_creacion=fecha_creacion;
        this.usuario_creador=usuario_creador;
        this.id_cuenta=id_cuenta;
    }
}
