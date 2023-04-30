package com.mensajeriaMackaia.Model;

import javax.persistence.*;

@Entity
@Table(name = "paquetes")
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_paquete")
    private Integer numeroPaquete;

    @Column(name = "tipo")
    private String Tipo;

    @Column(name = "peso")
    private Integer Peso;

    @Column(name = "valor_declarado")
    private Double valorDeclarado;

    public Paquete() {
    }

    public Paquete(Integer numeroPaquete, String tipo, Integer peso, Double valorDeclarado) {
        this.numeroPaquete = numeroPaquete;
        this.Tipo = tipo;
        this.Peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

    public Integer getNumeroPaquete() {
        return numeroPaquete;
    }

    public void setNumeroPaquete(Integer numeroPaquete) {
        this.numeroPaquete = numeroPaquete;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Integer getPeso() {
        return Peso;
    }

    public void setPeso(Integer peso) {
        Peso = peso;
    }

    public Double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(Double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }
}