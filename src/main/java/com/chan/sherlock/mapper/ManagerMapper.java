package com.chan.sherlock.mapper;

import com.chan.sherlock.domain.Manager;
import com.chan.sherlock.dto.ManagerCreateDto;
import com.chan.sherlock.dto.ManagerDto;

public class ManagerMapper {

    public ManagerDto ManagerToManagerDto (Manager manager){
      ManagerDto managerDto=new ManagerDto();
      managerDto.setFirst_name(manager.getFirst_name());
      managerDto.setLast_name(manager.getLast_name());
      managerDto.setUsername(manager.getUsername());
      managerDto.setCompany_name(manager.getCompany_name());
      return managerDto;
    }

    public Manager managerCreateDtoToManager(ManagerCreateDto managerCreateDto){
        Manager manager=new Manager();
        manager.setFirst_name(managerCreateDto.getFirst_name());
        manager.setLast_name(managerCreateDto.getLast_name());
        manager.setUsername(managerCreateDto.getUsername());
        manager.setPassword(managerCreateDto.getPassword());
        manager.setEmail(managerCreateDto.getEmail());
        manager.setPhone_number(managerCreateDto.getPhone_number());
        manager.setDate_of_birth(managerCreateDto.getDate_of_birth());
        manager.setCompany_name(managerCreateDto.getCompany_name());
        manager.setDate_of_hiring(managerCreateDto.getDate_of_hiring());
        return manager;
    }
}
