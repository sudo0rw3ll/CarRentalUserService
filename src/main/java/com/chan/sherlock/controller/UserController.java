package com.chan.sherlock.controller;

import com.chan.sherlock.dto.*;
import com.chan.sherlock.security.CheckSecurity;
import com.chan.sherlock.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @CheckSecurity(userTypes={"Admin","Manager","Client"})
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestHeader("Authorization") String authorization, Pageable pageable){
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Register client")
    @PostMapping("/registerClient")
    public ResponseEntity<ClientDto> saveClient(@RequestBody @Valid ClientCreateDto clientCreateDto){
        return new ResponseEntity<>(userService.createClient(clientCreateDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Register manager")
    @PostMapping("/registerManager")
    public ResponseEntity<ManagerDto> saveManager(@RequestBody @Valid ManagerCreateDto managerCreateDto){
        return new ResponseEntity<>(userService.createManager(managerCreateDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Login")
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody TokenRequestDto tokenRequestDto){
        return new ResponseEntity<>(userService.login(tokenRequestDto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update Client")
    @PutMapping("/updateClient/{id}")
    @CheckSecurity(userTypes={"Client","Admin"})
    public ResponseEntity<ClientDto> updateClient(@RequestHeader("Authorization") String authorization,
                                                  @RequestBody @Valid ClientUpdateDto clientUpdateDto,
                                                  @PathVariable("id") Long id){
        System.out.println(clientUpdateDto.getPassword());
        return new ResponseEntity<>(userService.updateClient(id, clientUpdateDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Update Manager")
    @PutMapping("/updateManager/{id}")
    @CheckSecurity(userTypes={"Admin","Manager"})
    public ResponseEntity<ManagerDto> updateManager(@RequestHeader("Authorization") String authorization,
                                                    @RequestBody @Valid ManagerUpdateDto managerUpdateDto, @PathVariable("id") Long id){
        return new ResponseEntity<>(userService.updateManager(id, managerUpdateDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Block user")
    @PostMapping("/blockUser/{id}")
    @CheckSecurity(userTypes={"Admin"})
    public ResponseEntity<UserDto> blockUser(@RequestHeader("Authorization") String authorization,
                                             @PathVariable("id") Long id){
        return new ResponseEntity<>(userService.blockUser(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Unblock user")
    @PostMapping("/unblockUser/{id}")
    @CheckSecurity(userTypes={"Admin"})
    public ResponseEntity<UserDto> unblockUser(@RequestHeader("Authorization") String authorization,
                                               @PathVariable("id") Long id){
        return new ResponseEntity<>(userService.unblockUser(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Calculate discount")
    @GetMapping("/discount/{id}")
    public ResponseEntity<DiscountDto> getDiscount(@PathVariable("id") Long user_id){
        return new ResponseEntity<>(userService.findDiscount(user_id), HttpStatus.OK);
    }
}
