package com.leonardo.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("/application.properties")
@SpringBootTest
public class ClientServiceTest {

    @Test
    public void createClientService() {
        clienteService.createClient("Leonardo", "Sena", "leosena@gmail.com");

//        Client client = clientDao.findByEmailAddress("leosena@gmail.com");
//
//        assertEquals("leosena@gmail.com", client.getEmailAddress(), "find by email");

    }
}
