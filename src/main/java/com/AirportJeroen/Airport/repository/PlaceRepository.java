package com.AirportJeroen.Airport.repository;

import com.AirportJeroen.Airport.model.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

    // JPA Custom method for finding airplanes by name.
    List<Place> findByName(String name);

}
