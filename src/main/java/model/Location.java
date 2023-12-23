package model;

public enum Location {
    SEAVIEW,
    INTERNALVIEW,
    STREETVIEW,
    GARDENVIEW,
    MOUNTAINVIEW;
     public String toString(Location location) {
        if (location == null) {
            return null;
        }

          switch (location) {
            case SEAVIEW:
                return "SEAVIEW";
            case STREETVIEW:
                return "STREETVIEW";
            case GARDENVIEW:
                return "GARDENVIEW";
            case MOUNTAINVIEW:
                return "MOUNTAINVIEW";    
            default:
                throw new IllegalArgumentException("Unknown characteristic: " + location);
        }
    }

    public static Location fromString(String location) {
        if (location == null) {
            return null;
        }

        switch (location.toUpperCase()) {
            case "SEAVIEW":
                return Location.SEAVIEW;
            case "STREETVIEW":
                return Location.STREETVIEW;
            case "GARDENVIEW":
                return Location.GARDENVIEW;
            case "MOUNTAINVIEW":
                return Location.MOUNTAINVIEW;    
            default:
                throw new IllegalArgumentException("Unknown location string: " + location);
        }
    }


}
