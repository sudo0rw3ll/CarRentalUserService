package com.chan.sherlock.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ManagerUpdateDto {

    @NotBlank
    private String first_name;

    @NotBlank
    private String last_name;

    @NotBlank
    private String username;

    @Length(min=12)
    private String password;

    @Email
    private String email;

    @NotBlank
    private String phone_number;

    @NotNull
    private LocalDate date_of_birth;

    @NotNull
    private LocalDate date_of_hiring;

    @NotBlank
    private String company_name;

    public LocalDate getDate_of_hiring() {
        return date_of_hiring;
    }

    public void setDate_of_hiring(LocalDate date_of_hiring) {
        this.date_of_hiring = date_of_hiring;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
