package com.example.s28854bank;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TransferService {

    private final ClientRegistry clientRegistry;

    public TransferService(ClientRegistry clientRegistry) {
        this.clientRegistry = clientRegistry;
    }

    public Client findClientByName(String name) {
        Client client = null;
        for (Client p : clientRegistry.getClientList()) {
            if (p.getName().equals(name)) {
                client = p;
                break;
            }
        }
        if (client == null) {
            throw new NoSuchElementException();
        } else {
            return client;
        }
    }

    public String transferIn(String name, double amout) {
        if(amout <= 0) {
            return "DECLINED: incorrect amout, balance not changed";
        }
        try {
            Client client = findClientByName(name);
            client.setBalance(client.getBalance() + amout);
            return "ACCEPTED, new balance = " + client.getBalance();
        } catch (NoSuchElementException exception) {
            return "DECLINED: no such client registered";
        }
    }

        public String transferOut(String name, double amount) {
            if(amount <= 0) {
                return "DECLINED: incorrect amout. Balance not changed";
            }
            try {
                Client client = findClientByName(name);
                if(client.getBalance() < amount) {
                    return "DECLINED: insufficient funds. Balance not changed";
                }
                client.setBalance(client.getBalance() - amount);
                return "ACCEPTED, new balance = " + client.getBalance();
            } catch (NoSuchElementException exception) {
                return "DECLINED: no such client registered";
            }
        }
}
