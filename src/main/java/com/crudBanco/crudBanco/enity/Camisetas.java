package com.crudBanco.crudBanco.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Camisetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String estilo;

    private int numero;

    public Camisetas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Camisetas{" +
                "id=" + id +
                ", estilo='" + estilo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}