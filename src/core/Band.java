package core;


import java.util.Objects;

public class Band {
    private String name;
    private String country;
    private String description;
    private int numberOfMembers;

    public Band(String name, String country, String description, int numberOfMembers) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.numberOfMembers = numberOfMembers;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return numberOfMembers == band.numberOfMembers &&
                Objects.equals(name, band.name) &&
                Objects.equals(country, band.country) &&
                Objects.equals(description, band.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, description, numberOfMembers);
    }

    @Override
    public String toString() {
        return "Band{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", numberOfMembers=" + numberOfMembers +
                '}';
    }
}