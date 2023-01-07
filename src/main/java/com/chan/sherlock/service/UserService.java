package com.chan.sherlock.service;

import com.chan.sherlock.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDto> findAll(Pageable pageable);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

    ManagerDto createManager(ManagerCreateDto managerCreateDto);
    ManagerDto updateManager(Long id, ManagerUpdateDto managerUpdateDto);

    ClientDto createClient(ClientCreateDto clientCreateDto);
    ClientDto updateClient(Long id, ClientUpdateDto clientUpdateDto);

    void deleteUserById(Long id);
}
