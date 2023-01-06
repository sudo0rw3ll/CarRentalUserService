package com.chan.sherlock.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String passport_number;
    private int rental_period;
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public int getRental_period() {
        return rental_period;
    }

    public void setRental_period(int rental_period) {
        this.rental_period = rental_period;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
