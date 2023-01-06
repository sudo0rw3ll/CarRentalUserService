package com.chan.sherlock.service;

import com.chan.sherlock.dto.ManagerCreateDto;
import com.chan.sherlock.dto.ManagerDto;
import com.chan.sherlock.dto.ManagerUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagerService {

    Page<ManagerDto> findAll(Pageable pageable);

    ManagerDto registerManager(ManagerCreateDto managerCreateDto);
    ManagerDto updateManagerData(ManagerUpdateDto managerUpdateDto);
}
