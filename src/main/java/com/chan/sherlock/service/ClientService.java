package com.chan.sherlock.service;

import com.chan.sherlock.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    Page<ClientDto> findAll(Pageable pageable);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

    ClientDto registerClient(ClientCreateDto clientCreateDto);
    ClientDto updateClientData(Long id, ClientUpdateDto clientUpdateDto);
}
