package com.mensajeriaMackaia.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @Column(name = "cedula")
    private Long Cedula;

    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "apellidos")
    private String Apellidos;

    @Column(name = "celular")
    private String Celular;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "direccion")
    private String Direccion;

    @Column(name = "ciudad")
    private String Ciudad;

    @Column(name = "antiguedad")
    private String Antiguedad;
    @Column(name = "rh")
    private String Rh;

    @Column(name = "tipo_empleado")
    private String tipoEmpleado;

    public Empleado() {
    }

    public Empleado(Long cedula, String nombre, String apellidos, String celular, String correoElectronico, String direccion, String ciudad, String antiguedad, String rh, String tipoEmpleado){
        this.Cedula = cedula;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Celular = celular;
        this.correoElectronico = correoElectronico;
        this.Direccion = direccion;
        this.Ciudad = ciudad;
        this.Antiguedad = antiguedad;
        this.Rh = rh;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Long getCedula() {
        return Cedula;
    }

    public void setCedula(Long cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getAntiguedad() {
        return Antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        Antiguedad = antiguedad;
    }

    public String getRh() {
        return Rh;
    }

    public void setRh(String rh) {
        Rh = rh;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}