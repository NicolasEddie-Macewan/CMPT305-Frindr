package com.example.frindr.backend.fruit;

//ID 3109665
// name Owen Woollam

public class location {
    private final double latitude;
    private final double longitude;
    //=================================================================
    //=================================================================
    public location(double latitude, double longitude) {
        this.latitude = check_latitude(latitude);
        this.longitude = check_longitude(longitude);
    }
    //=================================================================
    //=================================================================
    private double check_latitude(double value){
        if (value >= -90 && value <= 90) {
            return value;
        }
        throw new IllegalArgumentException("latitude must be within the range -90 and 90");
    }
    //=================================================================
    //=================================================================\
    private double check_longitude(double value){
        if (value >= -180 && value <= 180) {
            return value;
        }
        throw new IllegalArgumentException("longitude must be within the range -180 and 180");
    }
    //=================================================================
    //=================================================================
    public double getdistance(location other) {
        double dy=this.latitude - other.latitude;
        double dx=this.longitude - other.longitude;
        return Math.sqrt(dx*dx + dy*dy);
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    @Override
    public String toString() {
        return "Point ("+ latitude +", "+ longitude+")";
    }

    //=================================================================
    //=================================================================
    public boolean equals(location o) {
        if (this.latitude == o.getLatitude()) {
            return this.longitude == o.getLongitude();
        }
        return false;
    }
}


