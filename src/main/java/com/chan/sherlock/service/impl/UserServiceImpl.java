package com.chan.sherlock.service.impl;

import com.chan.sherlock.domain.Client;
import com.chan.sherlock.domain.Manager;
import com.chan.sherlock.domain.User;
import com.chan.sherlock.dto.*;
import com.chan.sherlock.exception.NotFoundException;
import com.chan.sherlock.mapper.ClientMapper;
import com.chan.sherlock.mapper.ManagerMapper;
import com.chan.sherlock.mapper.UserMapper;
import com.chan.sherlock.repository.UserRepository;
import com.chan.sherlock.security.service.TokenService;
import com.chan.sherlock.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    private TokenService tokenService;
    private UserRepository userRepository;
    private UserMapper userMapper;
    private ManagerMapper managerMapper; //dodao ja managerMapper
    private ClientMapper clientMapper; //dodao ja clientMapper

    public UserServiceImpl(TokenService tokenService, UserRepository userRepository, UserMapper userMapper,
                           ManagerMapper managerMapper, ClientMapper clientMapper) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.managerMapper = managerMapper; //dodao ja managerMapper
        this.clientMapper = clientMapper;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return (Page<UserDto>) userRepository.findAll(pageable)
                .map(userMapper::UserToUserDto);
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        //pronalazi aktivnog usera za kredencijale
        User user= userRepository
                .findUserByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
                .orElseThrow(()-> new NotFoundException(String.
                        format("User with username: %s and password %s not found",
                                tokenRequestDto.getUsername(),tokenRequestDto.getPassword())));

        Claims claims= Jwts.claims();
        claims.put("id", user.getId());
        claims.put("type",user.getType());
        return new TokenResponseDto(tokenService.generate(claims));
    }

    @Override
    public ManagerDto createManager(ManagerCreateDto managerCreateDto) {
        Manager manager = managerMapper.managerCreateDtoToManager(managerCreateDto);
        userRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }

    @Override
    public ManagerDto updateManager(Long id, ManagerUpdateDto managerUpdateDto) {
        Manager manager = (Manager) userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Manager with id %d not found", id)));

        manager.setCompany_name(managerUpdateDto.getCompany_name());
        manager.setDate_of_birth(managerUpdateDto.getDate_of_birth());
        manager.setUsername(managerUpdateDto.getUsername());
        manager.setPhone_number(managerUpdateDto.getUsername());
        manager.setFirst_name(managerUpdateDto.getFirst_name());
        manager.setLast_name(managerUpdateDto.getLast_name());
        manager.setEmail(managerUpdateDto.getEmail());
        manager.setDate_of_hiring(managerUpdateDto.getDate_of_hiring());

        return managerMapper.managerToManagerDto(userRepository.save(manager));
    }

    @Override
    public ClientDto createClient(ClientCreateDto clientCreateDto) {
        Client client = clientMapper.clientCreateDtoToClient(clientCreateDto);
        userRepository.save(client);

        return clientMapper.clientToClientDto(client);
    }

    @Override
    public ClientDto updateClient(Long id, ClientUpdateDto clientUpdateDto) {
        Client client = (Client) userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id %d not found", id)));

        client.setFirst_name(clientUpdateDto.getFirst_name());
        client.setLast_name(clientUpdateDto.getLast_name());
        client.setUsername(clientUpdateDto.getUsername());
        client.setPassword(clientUpdateDto.getPassword());
        client.setEmail(clientUpdateDto.getEmail());
        client.setPhone_number(clientUpdateDto.getPhone_number());
        client.setDate_of_birth(clientUpdateDto.getDate_of_birth());
        client.setPassport_number(clientUpdateDto.getPassport_number());
        client.setRental_period(clientUpdateDto.getRental_period());

        return clientMapper.clientToClientDto(userRepository.save(client));
    }

    @Override
    public UserDto blockUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id %d not found", id)));

        user.setIs_active(0);

        return userMapper.UserToUserDto(userRepository.save(user));
    }

    @Override
    public UserDto unblockUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id %d not found", id)));

        user.setIs_active(1);

        return userMapper.UserToUserDto(userRepository.save(user));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
