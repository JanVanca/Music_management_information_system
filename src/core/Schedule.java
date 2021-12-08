package core;

import Service.Service;

import java.util.Date;
import java.util.List;

public class Schedule extends Service<Band> {

    private Stage stage;
    private Manager manager;
    private Date date;
    private String time;
    private Band band;

    public Schedule(Date date, String time) {
        this.date = date;
        this.time = time;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void addToList(Band item) {
        super.addToList(item);
    }

    @Override
    public List<Band> getFromList() {
        return super.getFromList();
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "stage=" + stage +
                ", manager=" + manager +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", band=" + band +
                '}';
    }
}