package com.example;

import java.io.Serializable;
import java.util.Objects;

public class Aparelho implements Serializable {
    private String id;
    private String marca;
    private double preco;

    public Aparelho(String id, String marca, double preco) {
        this.id = id;
        this.marca = marca;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Aparelho{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Aparelho aparelho = (Aparelho) o;
        return Objects.equals(id, aparelho.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
