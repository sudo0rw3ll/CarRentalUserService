package com.chan.sherlock.controller;

import com.chan.sherlock.dto.TokenRequestDto;
import com.chan.sherlock.dto.TokenResponseDto;
import com.chan.sherlock.dto.UserCreateDto;
import com.chan.sherlock.dto.UserDto;
import com.chan.sherlock.security.CheckSecurity;
import com.chan.sherlock.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @ApiOperation(value = "Get all users")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page", value="What page number you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name="size", value="Number of items to return", dataType = "string",paramType = "query"),
            @ApiImplicitParam(name="sort",allowMultiple = true, dataType = "string", paramType = "query",
            value="Sorting criteria in the format: property(, asc|desc). "+
            "Default sort order is ascending. "+
            "Multiple sort criteria are supported.")})
    @GetMapping
    @CheckSecurity(userTypes={"ADMIN","MANAGER","USER"})
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestHeader("Authorization") String authorization, Pageable pageable){
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Register user")
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserCreateDto userCreateDto){
        return new ResponseEntity<>(userService.add(userCreateDto),HttpStatus.CREATED);
    }

    @ApiOperation(value = "Login")
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody TokenRequestDto tokenRequestDto){
        return new ResponseEntity<>(userService.login(tokenRequestDto),HttpStatus.OK);
    }

    //ovde sam stao

}
