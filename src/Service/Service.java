package Service;

import java.util.ArrayList;
import java.util.List;

public abstract class Service<T> {

    List<T> container = new ArrayList<>();

    public void addToList(T item) {
        container.add(item);
    }

    public List<T> getFromList() {
        return new ArrayList<T>(container);
    }

    public void removeFromList(T item) {
        container.remove(item);
    }

    public void removeAllFromList() {
        container.clear();
    }
}