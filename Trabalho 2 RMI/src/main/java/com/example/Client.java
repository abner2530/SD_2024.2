package com.example;

import java.rmi.Naming;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            Transferivel deposito = (Transferivel) Naming.lookup("rmi://localhost:1099/DepositoService");

            Aparelho tv = new TV("1", "Samsung", 1500.0, 55);
            Aparelho radio = new Radio("2", "Sony", 300.0, "FM");

            deposito.adicionarAparelho(tv);
            deposito.adicionarAparelho(radio);

            List<Aparelho> aparelhos = deposito.listarAparelhos();
            for (Aparelho aparelho : aparelhos) {
                System.out.println(aparelho);
            }

            Aparelho aparelhoBuscado = deposito.buscarAparelhoPorId("1");
            System.out.println("Aparelho buscado: " + aparelhoBuscado);

            deposito.removerAparelho(tv);

            aparelhos = deposito.listarAparelhos();
            for (Aparelho aparelho : aparelhos) {
                System.out.println(aparelho);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
