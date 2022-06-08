package com.leonardo.tdd;

import com.leonardo.tdd.models.Client;
import com.leonardo.tdd.repository.ClientDao;
import com.leonardo.tdd.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource("/application.properties")
@SpringBootTest
public class CreateClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientDao clientDao;

    @Test
    public void createStudentService() {
        clientService.createClient("Leonardo", "Sena", "leosena@gmail.com");

        Client client = clientDao.findByEmailAddress("leosena@gmail.com");

        assertEquals("leosena@gmail.com", client.getEmailAddress(), "find by email");
    }

    @Test
    public void isClientNullCheck() {

    }
}
