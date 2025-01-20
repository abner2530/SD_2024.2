package com.example.Testes_Q2;

import com.example.Model.AparelhosInputStream;

import java.io.IOException;

public class TesteEntradaPadrao {
    public static void main(String[] args) {
        try {
            // Crie um objeto de AparelhosInputStream utilizando a entrada padrão
            AparelhosInputStream inputStream = new AparelhosInputStream(System.in);
            System.out.println("Digite os dados dos aparelhos:");
            inputStream.lerAparelhos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
