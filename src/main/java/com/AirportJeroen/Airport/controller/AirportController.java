package com.AirportJeroen.Airport.controller;

import com.AirportJeroen.Airport.model.Airplane;
import com.AirportJeroen.Airport.model.Place;
import com.AirportJeroen.Airport.repository.PlaceRepository;
import com.AirportJeroen.Airport.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airplanes/")
public class AirportController {

    @Autowired
    PlaneRepository airplaneRepository;

    @Autowired
    PlaceRepository airportRepository;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Airplane> getAllPlanes() {
        return this.airplaneRepository.findAll();
    }

    @RequestMapping(value = "initialize", method = RequestMethod.GET)
    public void initialize() {

        Airplane plane1 = this.airplaneRepository.save(new Airplane("XYZ0001"));
        Airplane plane2 = this.airplaneRepository.save(new Airplane("XYZ0002"));
        Airplane plane3 = this.airplaneRepository.save(new Airplane("XYZ0003"));
        Airplane plane4 = this.airplaneRepository.save(new Airplane("XYZ0004"));
        Airplane plane5 = this.airplaneRepository.save(new Airplane("XYZ0005"));

        Place amsterdam =  new Place("Amsterdam");
        Place berlin =  new Place("Berlin");
        Place stockholm =  new Place("Stockholm");
        Place paris =  new Place("Paris");
        Place london =  new Place("London");

        amsterdam.addPlane(plane1);
        berlin.addPlane(plane2);
        stockholm.addPlane(plane3);
        paris.addPlane(plane4);
        london.addPlane(plane5);

        this.airportRepository.save(amsterdam);
        this.airportRepository.save(berlin);
        this.airportRepository.save(stockholm);
        this.airportRepository.save(paris);
        this.airportRepository.save(london);

    }
}
