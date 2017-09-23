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
public class Empleado {
    private String id_codigo;
    private String nombre_emp;
    private int telefono_emp;
    private String direccion_emp;
    private String correo_emp;
    private String Nacimiento_emp;
    private java.util.Date fecha_inicio;
    private java.util.Date antiguedad;
    private java.util.Date fecha_creacion;
    private java.util.Date fecha_modificacion;
    private String Usuario_creador,Usuario_modificador;
    
    public Empleado(String id_codigo,String nombre_emp,int telefono_emp,String direccion_emp,String correo_emp,String Nacimiento_emp,java.util.Date fecha_inicio,
            java.util.Date antiguedad,java.util.Date fecha_creacion,java.util.Date fecha_modificacion,String Usuario_creador,String Usuario_modificador){
        this.id_codigo=id_codigo;
        this.nombre_emp=nombre_emp;
        this.telefono_emp=telefono_emp;
        this.direccion_emp=direccion_emp;
        this.correo_emp=correo_emp;
        this.Nacimiento_emp=Nacimiento_emp;
        this.fecha_inicio=fecha_inicio;
        this.antiguedad=antiguedad;
        this.fecha_creacion=fecha_creacion;
        this.fecha_modificacion=fecha_modificacion;
        this.Usuario_creador=Usuario_creador;
        this.Usuario_modificador=Usuario_modificador;
    }

    Empleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public String getId_codigo() {
        return id_codigo;
    }

    public String getNombre_emp() {
        return nombre_emp;
    }

    public int getTelefono_emp() {
        return telefono_emp;
    }

    public String getDireccion_emp() {
        return direccion_emp;
    }

    public String getCorreo_emp() {
        return correo_emp;
    }

    public String getNacimiento_emp() {
        return Nacimiento_emp;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public Date getAntiguedad() {
        return antiguedad;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public String getUsuario_creador() {
        return Usuario_creador;
    }

    public String getUsuario_modificador() {
        return Usuario_modificador;
    }
    
       public void setId_codigo(String id_codigo) {
        this.id_codigo = id_codigo;
    }

    public void setNombre_emp(String nombre_emp) {
        this.nombre_emp = nombre_emp;
    }

    public void setTelefono_emp(int telefono_emp) {
        this.telefono_emp = telefono_emp;
    }

    public void setDireccion_emp(String direccion_emp) {
        this.direccion_emp = direccion_emp;
    }

    public void setCorreo_emp(String correo_emp) {
        this.correo_emp = correo_emp;
    }

    public void setNacimiento_emp(String Nacimiento_emp) {
        this.Nacimiento_emp = Nacimiento_emp;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setAntiguedad(Date antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public void setUsuario_creador(String Usuario_creador) {
        this.Usuario_creador = Usuario_creador;
    }

    public void setUsuario_modificador(String Usuario_modificador) {
        this.Usuario_modificador = Usuario_modificador;
    }
    
}
