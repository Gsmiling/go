package model;

public enum Characteristic {
    VENTILATED,
    CONDITIONNED;
     public String toString(Characteristic ch) {
        if (ch == null) {
            return null;
        }

          switch (ch) {
            case VENTILATED:
                return "VENTILATED";
            case CONDITIONNED:
                return "CONDITIONNED";
            default:
                throw new IllegalArgumentException("Unknown characteristic: " + ch);
        }
    }

    public static Characteristic fromString(String ch) {
        if (ch == null) {
            return null;
        }

        switch (ch.toUpperCase()) {
            case "VENTILATED":
                return Characteristic.VENTILATED;
            case "CONDITIONNED":
                return Characteristic.CONDITIONNED;
           
            default:
                throw new IllegalArgumentException("Unknown room type string: " + ch);
        }
    }

}
