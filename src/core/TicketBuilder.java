package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketBuilder {

    private String festivalName;
    private Date concertDate;
    private double price;
    private String concertLocation;
    private boolean parking;
    private int numberOfDays;
    private Integer count;

    public int getCount() {
        if (count == null) {
            return 1;
        }
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    public Date getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(Date concertDate) {
        this.concertDate = concertDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getConcertLocation() {
        return concertLocation;
    }

    public void setConcertLocation(String concertLocation) {
        this.concertLocation = concertLocation;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public List<Ticket> build() {
        List<Ticket> tickets = new ArrayList<>();
        Prototype<Ticket> prototypeTicket = new Ticket(getFestivalName(), getConcertDate(), getPrice(), getConcertLocation(), isParking(), getNumberOfDays());
        for (int i = 0; i < getCount(); i++) {
            tickets.add(prototypeTicket.clone());
        }
        return tickets;
    }
}