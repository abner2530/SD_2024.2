package com.example;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.example.Model.AparelhosOutputStream;
import com.example.Model.DVDPlayer;
import com.example.Model.Deposito;
import com.example.Model.Radio;
import com.example.Model.TV;

public class Main {
    public static void main(String[] args) {
        // Criando aparelhos
        TV tv = new TV("Samsung 4K", 2500.00, 55);
        DVDPlayer dvdPlayer = new DVDPlayer("Sony DVD", 400.00);
        Radio radio = new Radio("Philips FM", 150.00, "87.5 - 108 MHz");

        // Adicionando ao depósito
        Deposito deposito = new Deposito("Depósito Central");
        deposito.adicionarAparelho(tv);
        deposito.adicionarAparelho(dvdPlayer);
        deposito.adicionarAparelho(radio);

        // Listando aparelhos
        deposito.listarAparelhos();

        // Teste 1: Envio para saída padrão (System.out)
        try {
            System.out.println("\nEnviando dados para saída padrão:");
            AparelhosOutputStream stream = new AparelhosOutputStream(System.out, deposito.getAparelhos());
            stream.enviarAparelhos();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Teste 2: Envio para arquivo
        try (FileOutputStream fileOut = new FileOutputStream("aparelhos.dat")) {
            System.out.println("\nEnviando dados para arquivo:");
            AparelhosOutputStream stream = new AparelhosOutputStream(fileOut, deposito.getAparelhos());
            stream.enviarAparelhos();
            System.out.println("Dados enviados para o arquivo 'aparelhos.dat'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Teste 3: Envio para servidor TCP
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("\nEnviando dados para servidor TCP:");
            OutputStream socketOut = socket.getOutputStream();
            AparelhosOutputStream stream = new AparelhosOutputStream(socketOut, deposito.getAparelhos());
            stream.enviarAparelhos();
            System.out.println("Dados enviados para o servidor TCP.");
        } catch (IOException e) {
            System.err.println("Erro ao conectar ao servidor TCP. Certifique-se de que ele está em execução.");
            e.printStackTrace();
        }
    }
}