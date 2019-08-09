package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<OnClickObserver> observers = new ArrayList<>();

    public void addObserver(OnClickObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void notifyObservers() {
        for (OnClickObserver observer : observers) {
            observer.update();
        }
    }

//    public void notifyObservers(String selectedListString) {
//        for (OnClickObserver observer : observers) {
//            observer.update(selectedListString);
//        }
//    }
}
