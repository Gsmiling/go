/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gr
 */
public enum ClientCategory {
    PRIVATECLIENTS,
    BUSINESSCLIENTS,
    CLIENTGROUP,
    VIPCLIENTS;
     public String toString(ClientCategory clientCategory) {
        if (clientCategory == null) {
            return null;
        }

          switch (clientCategory) {
            case PRIVATECLIENTS:
                return "PRIVATECLIENTS";
            case BUSINESSCLIENTS:
                return " BUSINESSCLIENTS";
            case CLIENTGROUP:
                return "CLIENTGROUP";
            case VIPCLIENTS:
                return "VIPCLIENTS";    
            default:
                throw new IllegalArgumentException("Unknown client category: " + clientCategory);
        }
    }

    public static ClientCategory fromString(String clientCategory ){
        if (clientCategory == null) {
            return null;
        }

        switch (clientCategory.toUpperCase()) {
            case "PRIVATECLENTS":
                return ClientCategory.PRIVATECLIENTS;
            case "BUSINESSCLIENTS":
                return ClientCategory.BUSINESSCLIENTS;
            case "CLIENTGROUP":
                return ClientCategory.CLIENTGROUP;
            case "VIPCLIENTS":
                return ClientCategory.VIPCLIENTS;    
            default:
               throw new IllegalArgumentException("Unknown client category: " + clientCategory);
        }
    }

}
