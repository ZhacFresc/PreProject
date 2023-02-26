package com.example.kakpobeditleny;

import java.time.LocalDate;
import java.util.Date;

public class Store {
    public Integer id;
    public Integer petId;
    public Integer quantity;
    public Date shipDate;
    public String status;
    public Boolean complete;

    public Store(Integer id, Integer petId, Integer quantity, Date shipDate, String status, Boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }
}
