package core;

import java.util.Objects;

public class Manager {

    String name;
    String surname;
    String email;
    String telephone;

    public Manager(String name, String surname, String email, String telephone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(name, manager.name) &&
                Objects.equals(surname, manager.surname) &&
                Objects.equals(email, manager.email) &&
                Objects.equals(telephone, manager.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, telephone);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}