package com.aor.refactoring.example6;

public class Location {
    private String latitude;
    private String longitude;
    private String name;

    public Location(String locLatitude, String locLongitude, String locName) {
        this.latitude = locLatitude;
        this.longitude = locLongitude;
        this.name = locName;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return latitude + "," + longitude + " (" + name + ")";
    }
}
