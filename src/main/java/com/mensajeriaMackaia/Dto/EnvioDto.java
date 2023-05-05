package com.mensajeriaMackaia.Dto;
public class EnvioDto {

    private String numeroGuia;
    private Long cedulaCliente;
    private Long cedulaEmpleado;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String nombreDestinatario;
    private String celularDestinatario;
    private Double valorDeclarado;
    private Integer peso;
    private String estadoEnvio;
    private Long valorEnvio;

    public EnvioDto() {
    }

    public EnvioDto(String numeroGuia, Long cedulaCliente, Long cedulaEmpleado, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombreDestinatario,
                    String celularDestinatario, Double valorDeclarado, Integer peso, String estadoEnvio,Long valorEnvio) {

        this.numeroGuia = numeroGuia;
        this.cedulaCliente = cedulaCliente;
        this.cedulaEmpleado = cedulaEmpleado;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.nombreDestinatario = nombreDestinatario;
        this.celularDestinatario = celularDestinatario;
        this.valorDeclarado = valorDeclarado;
        this.peso = peso;
        this.estadoEnvio = estadoEnvio;
        this.valorEnvio=valorEnvio;
    }

    public EnvioDto(Long cedulaCliente, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombreDestinatario, String celularDestinatario,
                    Double valorDeclarado, Integer peso) {

        this.cedulaCliente = cedulaCliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.nombreDestinatario = nombreDestinatario;
        this.celularDestinatario = celularDestinatario;
        this.valorDeclarado = valorDeclarado;
        this.peso = peso;
    }


    public Long getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(Long valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public Long getCedulaCliente() {
        return cedulaCliente;
    }

    public Long getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public String getCelularDestinatario() {
        return celularDestinatario;
    }

    public Double getValorDeclarado() {
        return valorDeclarado;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public void setCedulaCliente(Long cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public void setCedulaEmpleado(Long cedulaEmpleado){

        this.cedulaEmpleado = cedulaEmpleado;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public void setCelularDestinatario(String celularDestinatario) {
        this.celularDestinatario = celularDestinatario;
    }

    public void setValorDeclarado(Double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }
}