package com.mongodb.devrel.gcr.aerodata;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AircraftRepository extends MongoRepository<Aircraft, String>{
    
    @Query("{_class: \"AircraftData\"}")
    List<Aircraft> findAllAircraft();
    
    @Query("{_id: /^?0/, _class: \"AircraftData\"}")
    List<Aircraft> findAircraftDataByIcaoAddr(String icaoAddr);
    
}
