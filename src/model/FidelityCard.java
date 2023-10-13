package model;

import java.util.Date;

public class FidelityCard extends IdentifiedObject {
    private final Date dateIssue;
    private final Date expirationDate;
    public FidelityCard(int id, Date dateIssue, Date expirationDate){
        this.dateIssue = dateIssue;
        this.expirationDate = expirationDate;
        this.id = id;
    }

    @Override
    public Integer getId() {
        return (Integer) super.getId();
    }

    public java.sql.Date getDateIssue() {

        return (java.sql.Date) dateIssue;
    }

    public java.sql.Date getExpirationDate() {
        return (java.sql.Date) expirationDate;
    }

}
