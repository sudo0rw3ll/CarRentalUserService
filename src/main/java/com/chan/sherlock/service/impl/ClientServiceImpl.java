package com.chan.sherlock.service.impl;

import com.chan.sherlock.domain.Client;
import com.chan.sherlock.dto.*;
import com.chan.sherlock.exception.NotFoundException;
import com.chan.sherlock.mapper.ClientMapper;
import com.chan.sherlock.repository.ClientRepository;
import com.chan.sherlock.security.service.TokenService;
import com.chan.sherlock.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ClientServiceImpl je implementacija metoda iz ClientService-a
 *  predstavlja servis koji ce kasnije biti koristen od strane
 *  controllera
 *
 * */

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private TokenService tokenService;
    private ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, TokenService tokenService){
        this.clientRepository = clientRepository;
        this.tokenService = tokenService;
    }

    @Override
    public Page<ClientDto> findAll(Pageable pageable) {
        return (Page<ClientDto>) clientRepository
                .findAll(pageable)
                .map(clientMapper::clientToClientDto);
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        return null;
    }

    @Override
    public ClientDto registerClient(ClientCreateDto clientCreateDto) {
        Client client = clientMapper.clientCreateDtoToClient(clientCreateDto);
        clientRepository.save(client);
        return clientMapper.clientToClientDto(client);
    }

    @Override
    public ClientDto updateClientData(Long id, ClientUpdateDto clientUpdateDto) {
        Client client = clientRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id %d not found", id)));

        client.setFirst_name(clientUpdateDto.getFirst_name());
        client.setLast_name(clientUpdateDto.getLast_name());
        client.setUsername(clientUpdateDto.getUsername());
        client.setPassword(clientUpdateDto.getPassword());
        client.setPhone_number(clientUpdateDto.getPhone_number());
        client.setEmail(clientUpdateDto.getPhone_number());
        client.setPassport_number(clientUpdateDto.getPassport_number());
        client.setRental_period(clientUpdateDto.getRental_period());
        client.setDate_of_birth(clientUpdateDto.getDate_of_birth());

        return clientMapper.clientToClientDto(client);
    }
}
