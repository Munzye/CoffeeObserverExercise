package co.edu.udistrital.cafe.service;

import co.edu.udistrital.cafe.model.LoteCafe;
import co.edu.udistrital.cafe.observer.Observer;
import co.edu.udistrital.cafe.observer.Subject;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class CooperativaCafeEspecial implements Subject<LoteCafe> {

    private final Set<Observer<LoteCafe>> observers = new LinkedHashSet<>();
    private LoteCafe ultimoLote;

    @Override
    public void subscribe(Observer<LoteCafe> observer) {
        if (observer == null) throw new IllegalArgumentException("Observer no puede ser null.");
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer<LoteCafe> observer) {
        if (observer == null) return;
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(LoteCafe event) {
        for (Observer<LoteCafe> o : observers) {
            o.update(event);
        }
    }

    public void registrarNuevoLote(LoteCafe lote) {
        if (lote == null) throw new IllegalArgumentException("Lote no puede ser null.");
        this.ultimoLote = lote;
        notifyObservers(lote);
    }

    public LoteCafe getUltimoLote() {
        return ultimoLote;
    }

    public Set<Observer<LoteCafe>> getObserversSnapshot() {
        return Collections.unmodifiableSet(observers);
    }

    public int getCantidadSuscriptores() {
        return observers.size();
    }
}
