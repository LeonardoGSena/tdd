package com.leonardo.tdd.service;

import com.leonardo.tdd.models.Client;
import com.leonardo.tdd.repository.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public void createClient(String firstname, String lastname, String emailAddress) {
        Client client = new Client(firstname, lastname, emailAddress);
        client.setId(0);
        clientDao.save(client);
    }
}
