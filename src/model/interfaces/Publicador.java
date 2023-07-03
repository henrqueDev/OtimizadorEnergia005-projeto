package model.interfaces;

public interface Publicador {
    void subscribe(Sensor o);

    void unsubscribe(Sensor o);

    void notifySubscribers();
}
