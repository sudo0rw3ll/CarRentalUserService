package com.chan.sherlock.mapper;

import com.chan.sherlock.domain.Admin;
import com.chan.sherlock.dto.AdminCreateDto;
import com.chan.sherlock.dto.AdminDto;

public class AdminMapper {

    public AdminDto adminDtoToAdmin(Admin admin){
        AdminDto adminDto=new AdminDto();
        adminDto.setUsername(admin.getUsername());
        return adminDto;
    }

    public Admin adminCreateDtoToAdmin(AdminCreateDto adminCreateDto){
        Admin admin= new Admin();
        admin.setFirst_name(adminCreateDto.getFirst_name());
        admin.setLast_name(adminCreateDto.getLast_name());
        admin.setUsername(adminCreateDto.getUsername());
        admin.setPassword(adminCreateDto.getPassword());
        admin.setEmail(adminCreateDto.getEmail());
        admin.setPhone_number(adminCreateDto.getPhone_number());
        admin.setDate_of_birth(adminCreateDto.getDate_of_birth());
        return admin;
    }
}
