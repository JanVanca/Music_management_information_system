package core;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Festival {

    private String name;
    private String country;
    private String address;
    private Date date;
    private List<Schedule> schedule;

    public Festival(String name, String country, String address, Date date) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.date = date;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Festival festival = (Festival) o;
        return Objects.equals(name, festival.name) &&
                Objects.equals(country, festival.country) &&
                Objects.equals(address, festival.address) &&
                Objects.equals(date, festival.date) &&
                Objects.equals(schedule, festival.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, address, date, schedule);
    }

    @Override
    public String toString() {
        return "Festival{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", schedule=" + schedule +
                '}';
    }
}