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
public class Prestamo {

    public int getNum_prestamo() {
        return num_prestamo;
    }

    public int getMonto() {
        return monto;
    }

    public int getPeriodos() {
        return periodos;
    }

    public int getSaldo() {
        return saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public String getTipo_prestamo() {
        return tipo_prestamo;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }

    public String getPrestamos_empleado() {
        return prestamos_empleado;
    }
    
    int num_prestamo,monto,periodos,saldo;
    java.util.Date fecha,fecha_creacion;
    String tipo_prestamo,usuario_creador,prestamos_empleado;
    
    public Prestamo(int num_prestamo,java.util.Date fecha,int monto,int periodos,int saldo,String tipo_prestamo,java.util.Date fecha_creacion,String usuario_creador,String prestamos_empleado){
        this.num_prestamo=num_prestamo;
        this.fecha=fecha;
        this.monto=monto;
        this.periodos=periodos;
        this.saldo=saldo;
        this.tipo_prestamo=tipo_prestamo;
        this.fecha_creacion=fecha_creacion;
        this.usuario_creador=usuario_creador;
        this.prestamos_empleado=prestamos_empleado;
    }
}
