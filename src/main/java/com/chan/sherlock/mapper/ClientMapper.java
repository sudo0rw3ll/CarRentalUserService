package com.chan.sherlock.mapper;

import com.chan.sherlock.domain.Client;
import com.chan.sherlock.dto.ClientCreateDto;
import com.chan.sherlock.dto.ClientDto;

public class ClientMapper {

    public ClientDto clientToClientDto(Client client){
        ClientDto clientDto = new ClientDto();

        clientDto.setFirst_name(client.getFirst_name());
        clientDto.setLast_name((client.getLast_name()));
        clientDto.setUsername(client.getUsername());
        clientDto.setEmail(client.getEmail());

        return clientDto;
    }

    public Client clientCreateDtoToClient(ClientCreateDto clientCreateDto){
        Client client = new Client();

        client.setFirst_name(clientCreateDto.getFirst_name());
        client.setLast_name(clientCreateDto.getLast_name());
        client.setUsername(clientCreateDto.getUsername());
        client.setEmail(clientCreateDto.getEmail());
        client.setPassword(clientCreateDto.getPassword());
        client.setPhone_number(clientCreateDto.getPhone_number());
        client.setDate_of_birth(clientCreateDto.getDate_of_birth());
        client.setPassport_number(clientCreateDto.getPassport_number());
        client.setRental_period(clientCreateDto.getRental_period());

        return client;
    }
}
