package core;

import java.util.Objects;

public class Stage {

    String name;
    boolean isCovered;

    public Stage(String name, boolean isCovered) {
        this.name = name;
        this.isCovered = isCovered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCovered() {
        return isCovered;
    }

    public void setCovered(boolean covered) {
        isCovered = covered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return isCovered == stage.isCovered &&
                Objects.equals(name, stage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isCovered);
    }

    @Override
    public String toString() {
        return "Stage{" +
                "name='" + name + '\'' +
                ", isCovered=" + isCovered +
                '}';
    }
}