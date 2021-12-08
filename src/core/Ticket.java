package core;

import java.util.Date;
import java.util.Objects;

public class Ticket implements Comparable<Ticket>, Prototype<Ticket> {

    private String festivalName;
    private Date concertDate;
    private double price;
    private String concertLocation;
    private boolean parking;
    private int numberOfDays;

    public Ticket(String festivalName, Date concertDate, double price, String concertLocation, boolean parking, int numberOfDays) {
        this.festivalName = festivalName;
        this.concertDate = concertDate;
        this.price = price;
        this.concertLocation = concertLocation;
        this.parking = parking;
        this.numberOfDays = numberOfDays;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.price, price) == 0 &&
                parking == ticket.parking &&
                numberOfDays == ticket.numberOfDays &&
                Objects.equals(festivalName, ticket.festivalName) &&
                Objects.equals(concertDate, ticket.concertDate) &&
                Objects.equals(concertLocation, ticket.concertLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(festivalName, concertDate, price, concertLocation, parking, numberOfDays);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "festivalName='" + festivalName + '\'' +
                ", concertDate=" + concertDate +
                ", price=" + price +
                ", concertLocation='" + concertLocation + '\'' +
                ", parking=" + parking +
                ", numberOfDays=" + numberOfDays +
                '}';
    }

    @Override
    public int compareTo(Ticket o) {
        return Double.compare(this.price, o.price);
    }

    /**
     * Prototype pattern.
     *
     * @return
     */
    @Override
    public Ticket clone() {
        return new Ticket(getFestivalName(), getConcertDate(), getPrice(), getConcertLocation(), isParking(), getNumberOfDays());
    }
}