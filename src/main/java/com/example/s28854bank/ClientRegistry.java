package com.example.s28854bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientRegistry {

    private List<Client> clientList;

    public ClientRegistry() {
        this.clientList = new ArrayList<>();
    }

    public void registerClient (Client client) {
        clientList.add(client);
    }

    public List<Client> getClientList () {
        return clientList;
    }
}
