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
public class Usuario {

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public String getId_empleado_usuario() {
        return id_empleado_usuario;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public Date getUltima_creacion() {
        return ultima_creacion;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }
    String usuario,contrasena,tipo,id_empleado_usuario;
    java.util.Date fecha_creacion,ultima_creacion;
    String usuario_creador,usuario_modificacion;
    
    public Usuario(String usuario,String contrasena,String tipo,String id_empleado_usuario,java.util.Date fecha_creacion,java.util.Date ultima_creacion,String usuario_creador,String usuario_modificacion){
        this.usuario=usuario;
        this.contrasena=contrasena;
        this.tipo=tipo;
        this.id_empleado_usuario=id_empleado_usuario;
        this.fecha_creacion=fecha_creacion;
        this.ultima_creacion=ultima_creacion;
        this.usuario_creador=usuario_creador;
        this.usuario_modificacion=usuario_modificacion;
    }
    
}
