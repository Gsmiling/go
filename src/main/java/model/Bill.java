package model;

import java.util.Date;

public class Bill extends IdentifiedObject{
    private Date billDate;
    private double amount;
    public Bill(int id, Date billDate, double amount){
        this.amount = amount;
        this.billDate = billDate;
        this.id =id;

    }
    
    public Date getBillDate() {
        return billDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
}
