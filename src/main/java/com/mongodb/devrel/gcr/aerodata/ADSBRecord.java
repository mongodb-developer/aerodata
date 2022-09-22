package com.mongodb.devrel.gcr.aerodata;

import java.util.Date;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aeroData")
@TypeAlias("ADSBRecord")
public class ADSBRecord extends AeroData {
    
    public Integer altitude; 
    public Integer heading;
    public Integer speed;
    public Integer verticalSpeed;
    public Date timestamp;
    public GeoPoint geoPoint;
    
    public ADSBRecord(String id, Integer altitude, Integer heading, Integer speed, Integer verticalSpeed, Date timestamp, GeoPoint geoPoint) {
        this.id = id;
        this.altitude = altitude;
        this.heading = heading;
        this.speed = speed;
        this.verticalSpeed = verticalSpeed;
        this.timestamp = timestamp;
        this.geoPoint = geoPoint;
    }

    @Override
    public String toString() {
        return String.format(
            "ADSB[id=%s, altitude='%d', heading='%d', speed='%d', verticalSpeed='%d' timestamp='%tc', latitude='%f', longitude='%f']",
            id, altitude, heading, speed, verticalSpeed, timestamp, geoPoint == null ? null : geoPoint.coordinates[1], geoPoint == null ? null : geoPoint.coordinates[0]);
    }
}