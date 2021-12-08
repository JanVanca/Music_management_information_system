package core;

public class PersonalInfo {

     String name;
     String surname;
     boolean isMale;

    public PersonalInfo(String name, String surname, boolean isMale) {
        this.name = name;
        this.surname = surname;
        this.isMale = isMale;
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

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}