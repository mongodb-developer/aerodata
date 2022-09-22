package com.mongodb.devrel.gcr.aerodata;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AirlineRepository extends MongoRepository<Airline, String>{
    
    @Query("{_class: \"AirlineData\"}")
    List<Airline> findAllAirlines();
    
    @Query(value="{_id: /^?0/, _class: \"AirlineData\"}", sort = "{_id: 1}")
    Optional<Airline> findAirlineByIcaoAddr(String icaoAddr);

}
