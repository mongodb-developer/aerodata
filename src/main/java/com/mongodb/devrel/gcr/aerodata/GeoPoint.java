package com.mongodb.devrel.gcr.aerodata;

public class GeoPoint {
    public String type;
    public Double[] coordinates;
    
    public GeoPoint(Double[] coordinates) {
        this.type = "Point";
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return String.format(
            "GeoPoint[latitude='%s', longitude='%s']",
            this.coordinates[1].toString(), this.coordinates[0].toString());
    }
}
