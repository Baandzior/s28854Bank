package com.example.s28854bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class TransferServiceTest {

    @Mock
    private ClientRegistry clientRegistry;

    @InjectMocks
    private TransferService transferService;

    @Test
    void shouldDoTransferIn() {
        when(clientRegistry.getClientList())
                .thenReturn(List.of(new Client("Kowalski", 150)));
        String outcome = transferService.transferIn("Kowalski", 3.68);
        assertThat(outcome).isEqualTo("ACCEPTED, new balance = 153.68");
    }
}
