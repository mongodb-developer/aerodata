package com.mongodb.devrel.gcr.aerodata;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aeroData")
@TypeAlias("AirlineData")
public class Airline extends AeroData{
    
    public String airlineName;
    public String country;
    public String countryISO;
    public String callsign;
    public String website;
    
    public Airline(String id, String airlineName, String country, String countryISO, String callsign, String website) {
        this.id = id;
        this.airlineName = airlineName;
        this.country = country;
        this.countryISO = countryISO;
        this.callsign = callsign;
        this.website = website;
    }

    @Override
    public String toString() {
        return String.format(
            "Airline[id=%s, name='%s', country='%s (%s)', callsign='%s', website='%s']",
            id, airlineName, country, countryISO, callsign, website);
    }
    
}
