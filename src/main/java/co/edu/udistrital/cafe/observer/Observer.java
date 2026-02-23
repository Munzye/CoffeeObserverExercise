package co.edu.udistrital.cafe.observer;

public interface Observer<T> {
    void update(T event);
}
