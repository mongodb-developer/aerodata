package com.mongodb.devrel.gcr.aerodata;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aeroData")
public abstract class AeroData {
    
    @Id
    public String id;
    
    //Getters and Setters...
    
}
