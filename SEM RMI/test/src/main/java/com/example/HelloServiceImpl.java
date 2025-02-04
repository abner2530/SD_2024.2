package com.example;

public class HelloServiceImpl extends HelloService {

    @Override
    public String sayHello(String name) {
        return "Olá, " + name + "! Este é um exemplo de RPC com sockets.";
    }
}
