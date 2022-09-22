package com.mongodb.devrel.gcr.aerodata;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ADSBRecordRepository extends MongoRepository<ADSBRecord, String>{
    
    @Query(value="{_class: \"ADSBRecord\"}",sort="{_id: 1}")
    List<ADSBRecord> findAllADSBRecords();
    
    @Query(value="{_id: /^.*?0/, _class: \"ADSBRecord\"}", sort = "{_id: 1}")
    List<ADSBRecord> findADSBDataByIcaoAddr(String icaoAddr);
    
}
