package model;

import java.util.Date;

public class Consommation extends  IdentifiedObject{
    private double servicePrice;
    private Date dateConso;
    public Consommation(int id, Date dateConso, double servicePrice){
        this.dateConso =dateConso;
        this.servicePrice =servicePrice;
        this.id = id;
    }

    @Override
    public Integer getId() {
        return(Integer) super.getId();
    }

    public Date getDateConso() {
        return dateConso;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setDateConso(Date dateConso) {
        this.dateConso = dateConso;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }
}
