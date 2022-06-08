package com.leonardo.tdd.service;

import com.leonardo.tdd.models.Client;
import com.leonardo.tdd.repository.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public void createClient(String firstname, String lastname, String emailAddress) {
        Client client = new Client(firstname, lastname, emailAddress);
        client.setId(1);
        clientDao.save(client);
    }

    public boolean checkIsClientIsNull(int id) {
        Optional<Client> client = clientDao.findById(id);
        if (client.isPresent()) {
            return true;
        }
        return false;
    }

    public void deleteStudent(int id) {
        if (checkIsClientIsNull(id)) {
            clientDao.deleteById(id);
        }
    }
}
