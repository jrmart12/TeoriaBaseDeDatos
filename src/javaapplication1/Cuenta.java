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
public class Cuenta {
    private String antiguedad,tipo,cuentas_empleado;
    private int saldo,abono_mensual,num_cuenta;
    private java.util.Date fecha_apertura,fecha_creacion,ultima_modificacion;
         private String   usuario_creador,usuario_modificador;
    
    public Cuenta(int num_cuenta,java.util.Date fecha_apertura,int saldo,String antiguedad,String tipo,java.util.Date fecha_creacion,java.util.Date ultima_modificacion,String usuario_creador,String usuario_modificador,int abono_mensual,String cuentas_empleado){
        this.antiguedad=antiguedad;
        this.tipo=tipo;
        this.cuentas_empleado=cuentas_empleado;
        this.saldo=saldo;
        this.abono_mensual=abono_mensual;
        this.num_cuenta=num_cuenta;
        this.fecha_apertura=fecha_apertura;
        this.fecha_creacion=fecha_creacion;
        this.ultima_modificacion=ultima_modificacion;
        this.usuario_creador=usuario_creador;
        this.usuario_modificador=usuario_modificador;
    }
    
     public String getAntiguedad() {
        return antiguedad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCuentas_empleado() {
        return cuentas_empleado;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getAbono_mensual() {
        return abono_mensual;
    }

    public int getNum_cuenta() {
        return num_cuenta;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public Date getUltima_modificacion() {
        return ultima_modificacion;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }

    public String getUsuario_modificador() {
        return usuario_modificador;
    }
    
}
