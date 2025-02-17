package com.example;

public class Radio extends Aparelho {
    private String frequencia;

    public Radio(String id, String marca, double preco, String frequencia) {
        super(id, marca, preco);
        this.frequencia = frequencia;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return "Radio{" + super.toString() + ", frequencia='" + frequencia + '\'' + '}';
    }
}
