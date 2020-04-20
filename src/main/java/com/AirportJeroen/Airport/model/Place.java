package com.AirportJeroen.Airport.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Places")
public class Place {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    public Place(@NotNull String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = Airplane.class, cascade = CascadeType.ALL)
    private List<Airplane> listOfPlanes = new ArrayList<Airplane>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlane(Airplane plane){
        listOfPlanes.add(plane);
    }

    public void removePlane(Airplane plane){
        listOfPlanes.remove(plane);
    }

    public void fuelUpPlane(Airplane plane){
        plane.setFuel(5);
        plane.setLowOnFuel(false);
    }

    public String fly(Airplane airplane, Place place){

        String message = "";
        int fuelFlight = 0;

        if(airplane.isLowOnFuel()){
            message = "The plane " + getName() + " is not able to take off due to low fuel" ;
        }
        else{
            message = "The plane " + getName() + " has flown to " + place.getName();
            fuelFlight = airplane.getFuel() - 2;
            airplane.setFuel(fuelFlight);
            airplane.checkFuelLevel();

            removePlane(airplane);
            place.addPlane(airplane);
        }

        return message;
    }
}
