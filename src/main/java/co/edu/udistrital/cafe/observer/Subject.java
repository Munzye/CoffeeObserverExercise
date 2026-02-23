package co.edu.udistrital.cafe.observer;

public interface Subject<T> {
    void subscribe(Observer<T> observer);
    void unsubscribe(Observer<T> observer);
    void notifyObservers(T event);
}
