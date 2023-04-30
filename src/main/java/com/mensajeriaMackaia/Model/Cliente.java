package com.mensajeriaMackaia.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
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

    public Cliente() {
    }

    public Cliente(Long cedula, String nombre, String apellidos, String celular, String correoElectronico, String direccion, String ciudad) {
        this.Cedula = cedula;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Celular = celular;
        this.correoElectronico = correoElectronico;
        this.Direccion = direccion;
        this.Ciudad = ciudad;
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
        Direccion = direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }
}