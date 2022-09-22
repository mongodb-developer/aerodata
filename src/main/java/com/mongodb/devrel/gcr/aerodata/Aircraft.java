package com.mongodb.devrel.gcr.aerodata;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aeroData")
@TypeAlias("AircraftData")
public class Aircraft extends AeroData{
    
    public String tailNumber;
    public String manufacturer;
    public String model;
    
    public Aircraft(String id, String tailNumber, String manufacturer, String model) {
        this.id = id;
        this.tailNumber = tailNumber;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format(
            "Aircraft[id=%s, tailNumber='%s', manufacturer='%s', model='%s']",
            id, tailNumber, manufacturer, model);
    }
    
}
