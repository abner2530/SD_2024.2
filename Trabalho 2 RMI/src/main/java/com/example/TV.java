package com.example;

public class TV extends Aparelho {
    private int tamanhoTela;

    public TV(String id, String marca, double preco, int tamanhoTela) {
        super(id, marca, preco);
        this.tamanhoTela = tamanhoTela;
    }

    public int getTamanhoTela() {
        return tamanhoTela;
    }

    public void setTamanhoTela(int tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    @Override
    public String toString() {
        return "TV{" + super.toString() + ", tamanhoTela=" + tamanhoTela + '}';
    }
}
