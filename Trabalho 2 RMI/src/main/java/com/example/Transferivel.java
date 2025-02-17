package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Transferivel extends Remote {
    void adicionarAparelho(Aparelho aparelho) throws RemoteException;

    void removerAparelho(Aparelho aparelho) throws RemoteException;

    List<Aparelho> listarAparelhos() throws RemoteException;

    Aparelho buscarAparelhoPorId(String id) throws RemoteException;
}
