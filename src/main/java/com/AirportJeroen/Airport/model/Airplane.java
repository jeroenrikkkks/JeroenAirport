package com.AirportJeroen.Airport.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Airplane {


    public Airplane(@NotNull String name) {
        this.name = name;
        this.fuel = 5;
        this.isLowOnFuel = false;
    }

    @Id
    @GeneratedValue
    private long planeId;

    @NotNull
    private String name;

    private int fuel;

    private boolean isLowOnFuel;

    public long getId() {
        return planeId;
    }

    public void setId(long id) {
        this.planeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public boolean isLowOnFuel() {
        return isLowOnFuel;
    }

    public void setLowOnFuel(boolean lowOnFuel) {
        isLowOnFuel = lowOnFuel;
    }

    public void checkFuelLevel() {
        if(getFuel() < 2){
            setLowOnFuel(true);
        }
    }


}
