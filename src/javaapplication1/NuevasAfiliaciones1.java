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
public class NuevasAfiliaciones1 {

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha_afiliacion() {
        return fecha_afiliacion;
    }

    public int getInversion() {
        return inversion;
    }

    public int getAhorro() {
        return ahorro;
    }

    public int getTotal() {
        return total;
    }
    String codigo_empleado,nombre;
    java.util.Date fecha_afiliacion;
    int inversion,ahorro,total;
    public NuevasAfiliaciones1(String codigo_empleado,String nombre,java.util.Date fecha_afiliacion,int inversion,int ahorro,int total){
        this.codigo_empleado=codigo_empleado;
        this.nombre=nombre;
        this.fecha_afiliacion=fecha_afiliacion;
        this.inversion=inversion;
        this.ahorro=ahorro;
        this.total=total;
    }
}
