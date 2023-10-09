package model;

import java.util.Date;

public class FidelityCard extends IdentifiedObject {
    private Date dateIssue;
    private Date expirationDate;
    public FidelityCard(int id, Date dateIssue, Date expirationDate){
        this.dateIssue = dateIssue;
        this.expirationDate = expirationDate;
        this.id = id;
    }

    @Override
    public Integer getId() {
        return (Integer) super.getId();
    }

    public Date getDateIssue() {

        return dateIssue;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

}
