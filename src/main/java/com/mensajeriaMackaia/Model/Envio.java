package com.mensajeriaMackaia.Model;

import javax.persistence.*;

@Entity
@Table(name = "envios")
public class Envio {

    @Id
    @Column(name = "numero_guia")
    private String numeroGuia;

    @ManyToOne
    @JoinColumn(name = "cedula_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cedula_empleado")
    private Empleado empleado;

    @OneToOne
    @JoinColumn(name = "numero_paquete")
    private Paquete paquete;

    @Column(name = "ciudad_origen")
    private String ciudadOrigen;

    @Column(name = "ciudad_destino")
    private String ciudadDestino;

    @Column(name = "direccion_destino")
    private String direccionDestino;

    @Column(name = "nombre_destinatario")
    private String nombreDestinatario;

    @Column(name = "celular_destinatario")
    private String celularDestinatario;

    @Column(name = "hora_entrega")
    private String horaEntrega;

    @Column(name = "estado_envio")
    private String estadoEnvio;

    @Column(name = "valor_envio")
    private Long valorEnvio;

    public Envio() {
    }

    public Envio(String numeroGuia, Cliente cliente, Empleado empleado, Paquete paquete, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombreDestinatario, String celularDestinatario, String horaEntrega, String estadoEnvio, Long valorEnvio) {
        this.numeroGuia = numeroGuia;
        this.cliente = cliente;
        this.empleado = empleado;
        this.paquete = paquete;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.nombreDestinatario = nombreDestinatario;
        this.celularDestinatario = celularDestinatario;
        this.horaEntrega = horaEntrega;
        this.estadoEnvio = estadoEnvio;
        this.valorEnvio = valorEnvio;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getCelularDestinatario() {
        return celularDestinatario;
    }

    public void setCelularDestinatario(String celularDestinatario) {
        this.celularDestinatario = celularDestinatario;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Long getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(Long valorEnvio) {
        this.valorEnvio = valorEnvio;
    }
}