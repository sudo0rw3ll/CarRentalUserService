package com.chan.sherlock.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Manager extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company_name;
    private LocalDate date_of_hiring;


    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setDate_of_hiring(LocalDate date_of_hiring) {
        this.date_of_hiring = date_of_hiring;
    }
    public LocalDate getDate_of_hiring() {
        return date_of_hiring;
    }

    public String getCompany_name() {
        return company_name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
