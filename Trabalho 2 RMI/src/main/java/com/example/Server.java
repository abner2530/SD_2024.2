package com.example;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Deposito deposito = new Deposito("Deposito Central");
            Naming.rebind("rmi://localhost:1099/DepositoService", deposito);
            System.out.println("Servidor pronto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
