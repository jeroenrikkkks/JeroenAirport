package com.AirportJeroen.Airport.repository;

import com.AirportJeroen.Airport.model.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository extends CrudRepository<Airplane, Long>{

    // JPA Custom method for finding airplanes by name.
    List<Airplane> findByName(String name);

}
