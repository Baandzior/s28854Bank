package com.example.s28854bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransferServiceITest {

    @Autowired
    private TransferService transferService;

    @Autowired
    private ClientRegistry clientRegistry;


    /*@BeforeEach
    void beforeEach() {
        this.clientRegistry.clear();
    }*/

    @Test
    void shouldDoTransferIn() {
        this.clientRegistry.registerClient(new Client("Kowalski", 760.0));
        String outcome = transferService.transferIn("Kowalski", 3.68);
        assertThat(outcome).isEqualTo("ACCEPTED, new balance = 763.68");
    }

    @Test
    void shouldNotFindClient() {
        assertThrows(NoSuchElementException.class, () -> {
            transferService.findClientByName("kowalski");
        });
    }
}
