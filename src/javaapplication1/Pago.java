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
public class Pago {

    public Date getFecha() {
        return fecha;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public int getMonto() {
        return monto;
    }

    public int getIntereses() {
        return intereses;
    }

    public int getCapital() {
        return capital;
    }

    public int getPagos_prestamos() {
        return pagos_prestamos;
    }

    public int getNum_pago() {
        return num_pago;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }
    java.util.Date fecha,fecha_creacion;
            int monto,intereses,capital,pagos_prestamos,num_pago;
                    String usuario_creador;
    public Pago(java.util.Date fecha,int monto,int intereses,int capital,java.util.Date fecha_creacion,String usuario_creador,int pagos_prestamos,int num_pago){
        this.fecha=fecha;
        this.monto=monto;
        this.intereses=intereses;
        this.capital=capital;
        this.fecha_creacion=fecha_creacion;
        this.usuario_creador= usuario_creador;
        this.pagos_prestamos=pagos_prestamos;
        this.num_pago=num_pago;
    }
}
