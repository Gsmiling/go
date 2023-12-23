package model;

public enum RoomType {
    SINGLE,
    DOUBLE,
    TRIPLE;
    
      public String toString(RoomType roomType) {
        if (roomType == null) {
            return null;
        }

          switch (roomType) {
            case SINGLE:
                return "SINGLE";
            case DOUBLE:
                return "DOUBLE";
            case TRIPLE:
                return "TRIPLE";
            default:
                throw new IllegalArgumentException("Unknown room type: " + roomType);
        }
    }

    public static RoomType fromString(String roomTypeString) {
        if (roomTypeString == null) {
            return null;
        }

        switch (roomTypeString.toUpperCase()) {
            case "SINGLE":
                return RoomType.SINGLE;
            case "DOUBLE":
                return RoomType.DOUBLE;
            case "TRIPLE":
                return RoomType.TRIPLE;
            default:
                throw new IllegalArgumentException("Unknown room type string: " + roomTypeString);
        }
    }

}
