package com.leonardo.tdd;

import com.leonardo.tdd.models.Client;
import com.leonardo.tdd.repository.ClientDao;
import com.leonardo.tdd.service.ClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
public class CreateClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setupDatabase() {
        jdbcTemplate.execute("insert into client(id, firstname, lastname, email_address) " +
                "values(1, 'Leonardo', 'Sena', 'leosena@gmail.com')");
    }

    @Test
    public void createStudentService() {
        clientService.createClient("Leonardo", "Sena", "leosena@gmail.com");

        Client client = clientDao.findByEmailAddress("leosena@gmail.com");

        assertEquals("leosena@gmail.com", client.getEmailAddress(), "find by email");
    }

    @Test
    public void isClientNullCheck() {
        assertTrue(clientService.checkIsClientIsNull(1));

        assertFalse(clientService.checkIsClientIsNull(0));
    }

    @Test
    public void deleteStudentService() {

    }

    @AfterEach
    public void SetupAfterTransaction() {
        jdbcTemplate.execute("DELETE FROM client");
    }
}
