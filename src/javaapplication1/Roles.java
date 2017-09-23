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
public class Roles {

    public Date getFecha_datos() {
        return fecha_datos;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public String getUsuario_creacion() {
        return usuario_creacion;
    }

    public String getActualizacion_datou() {
        return actualizacion_datou;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId_roles() {
        return id_roles;
    }
        java.util.Date fecha_datos,fecha_actualizacion;
    String usuario_creacion,actualizacion_datou,descripcion;
    int id_roles;
    public Roles(java.util.Date fecha_datos,java.util.Date fecha_actualizacion,String usuario_creacion,String actualizacion_datou,String descripcion,int id_roles){
        this.fecha_actualizacion=fecha_actualizacion;
        this.fecha_datos=fecha_datos;
        this.usuario_creacion=usuario_creacion;
        this.actualizacion_datou=actualizacion_datou;
        this.descripcion=descripcion;
        this.id_roles=id_roles;
    }
}
