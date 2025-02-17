package com.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Deposito extends UnicastRemoteObject implements Transferivel {
    private String nome;
    private List<Aparelho> aparelhos;

    public Deposito(String nome) throws RemoteException {
        this.nome = nome;
        this.aparelhos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aparelho> getAparelhos() {
        return aparelhos;
    }

    @Override
    public void adicionarAparelho(Aparelho aparelho) throws RemoteException {
        this.aparelhos.add(aparelho);
    }

    @Override
    public void removerAparelho(Aparelho aparelho) throws RemoteException {
        this.aparelhos.remove(aparelho);
    }

    @Override
    public List<Aparelho> listarAparelhos() throws RemoteException {
        return this.aparelhos;
    }

    @Override
    public Aparelho buscarAparelhoPorId(String id) throws RemoteException {
        for (Aparelho aparelho : aparelhos) {
            if (aparelho.getId().equals(id)) {
                return aparelho;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "nome='" + nome + '\'' +
                ", aparelhos=" + aparelhos +
                '}';
    }
}
