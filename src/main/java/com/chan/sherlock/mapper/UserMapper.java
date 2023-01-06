package com.chan.sherlock.mapper;

import com.chan.sherlock.domain.User;
import com.chan.sherlock.dto.UserCreateDto;
import com.chan.sherlock.dto.UserDto;

public class UserMapper {

    public UserDto UserToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setFirst_name(user.getFirst_name());
        userDto.setLast_name(user.getLast_name());
        userDto.setId(user.getId());
        return userDto;

    }

    public User UserCreateDtoToUser(UserCreateDto userCreateDto){
        User user=new User();
        user.setFirst_name(userCreateDto.getFirst_name());
        user.setLast_name(userCreateDto.getLast_name());
        user.setEmail(userCreateDto.getEmail());
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        return user;
    }
}
