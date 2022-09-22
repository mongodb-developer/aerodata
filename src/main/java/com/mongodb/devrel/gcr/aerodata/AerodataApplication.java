package com.mongodb.devrel.gcr.aerodata;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AerodataApplication implements CommandLineRunner {

    @Autowired
    private AirlineRepository airlineRepo;
    
    @Autowired
    private AircraftRepository aircraftRepo;
    
    @Autowired
    private ADSBRecordRepository adsbRepo;

    public static void main(String[] args) {
        SpringApplication.run(AerodataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Delete any records from a previous run;
        airlineRepo.deleteAll();

        // save an airline
        airlineRepo.save(new Airline("DAL", "Delta Air Lines", "United States", "US", "DELTA", "delta.com"));
        
        // add some aircraft aircraft
        aircraftRepo.save(new Aircraft("DAL_a93d7c", "N695CA", "Bombardier Inc", "CL-600-2D24"));
        aircraftRepo.save(new Aircraft("DAL_ab8379", "N8409N", "Bombardier Inc", "CL-600-2B19"));
        aircraftRepo.save(new Aircraft("DAL_a36f7e", "N8409N", "Airbus Industrie", "A319-114"));
        
        //Add some ADSB position reports
        Double[] coords1 = {-4.776722, 55.991776};
        GeoPoint geoPoint = new GeoPoint(coords1);
        adsbRepo.save(new ADSBRecord("DAL_a36f7e_1", 38825, 319, 428, 1024, new Date(1656980617041l), geoPoint));
        Double[] coords2 = {-4.781466, 55.994843};
        geoPoint = new GeoPoint(coords2);
        adsbRepo.save(new ADSBRecord("DAL_a36f7e_2", 38875, 319, 429, 1024, new Date(1656980618041l), geoPoint));
        Double[] coords3 = {-4.783344, 55.99606};
        geoPoint = new GeoPoint(coords3);
        adsbRepo.save(new ADSBRecord("DAL_a36f7e_3", 38892, 319, 428, 1024, new Date(1656980619041l), geoPoint));        
                

        // fetch all airlines
        System.out.println("Airlines found with findAllAirlines():");
        System.out.println("-------------------------------");
        for (Airline airline : airlineRepo.findAllAirlines()) {
            System.out.println(airline);
        }
        System.out.println();
        // fetch a specific airline by ICAO ID
        System.out.println("Airlines found with findAirlineByIcaoAddr(\"DAL\"):");
        System.out.println("-------------------------------");
        Optional<Airline> airlineResponse = airlineRepo.findAirlineByIcaoAddr("DAL");
        System.out.println(airlineResponse.get());
        
        System.out.println();

        // fetch all aircraft
        System.out.println("Aircraft found with findAllAircraft():");
        System.out.println("-------------------------------");
        for (Aircraft aircraft : aircraftRepo.findAllAircraft()) {
            System.out.println(aircraft);
        }
        System.out.println();
        // fetch Aircraft Documents specific to airline "DAL"
        System.out.println("Aircraft found with findAircraftDataByIcaoAddr(\"DAL\"):");
        System.out.println("-------------------------------");
        for (Aircraft aircraft : aircraftRepo.findAircraftDataByIcaoAddr("DAL")) {
            System.out.println(aircraft);
        }
        
        System.out.println();
        
        // fetch Aircraft Documents specific to aircraft "a36f7e"
        System.out.println("Aircraft found with findAircraftDataByIcaoAddr(\"a36f7e\"):");
        System.out.println("-------------------------------");
        for (Aircraft aircraft : aircraftRepo.findAircraftDataByIcaoAddr("a36f7e")) {
            System.out.println(aircraft);
        }
        
        System.out.println();
        
        // fetch all adsb records
        System.out.println("ADSB records found with findAllADSBRecords():");
        System.out.println("-------------------------------");
        for (ADSBRecord adsb : adsbRepo.findAllADSBRecords()) {
            System.out.println(adsb);
        }
        System.out.println();
        // fetch ADSB Documents specific to airline "DAL"
        System.out.println("ADSB Documents found with findADSBDataByIcaoAddr(\"DAL\"):");
        System.out.println("-------------------------------");
        for (ADSBRecord adsb : adsbRepo.findADSBDataByIcaoAddr("DAL")) {
            System.out.println(adsb);
        }
        
        System.out.println();
        
        // fetch ADSB Documents specific to aircraft "a36f7e"
        System.out.println("ADSB Documents found with findADSBDataByIcaoAddr(\"a36f7e\"):");
        System.out.println("-------------------------------");
        for (ADSBRecord adsb : adsbRepo.findADSBDataByIcaoAddr("a36f7e")) {
            System.out.println(adsb);
        }
        
        //Clean up the data
        //airlineRepo.deleteAll();
        
    }

}
