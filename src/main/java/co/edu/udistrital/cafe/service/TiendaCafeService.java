package co.edu.udistrital.cafe.service;

import co.edu.udistrital.cafe.model.Barista;
import co.edu.udistrital.cafe.model.LoteCafe;

import java.util.*;

public class TiendaCafeService {

    private final CooperativaCafeEspecial cooperativa;
    private final Map<String, Barista> baristasPorId = new HashMap<>();

    public TiendaCafeService(CooperativaCafeEspecial cooperativa) {
        if (cooperativa == null) throw new IllegalArgumentException("Cooperativa requerida.");
        this.cooperativa = cooperativa;
    }

    //NewBarista
    public Barista crearBarista(String nombre, String identificacion) {
        if (baristasPorId.containsKey(identificacion)) {
            throw new IllegalStateException("Ya existe un barista con id: " + identificacion);
        }
        Barista b = new Barista(nombre, identificacion);
        baristasPorId.put(b.getIdentificacion(), b);
        return b;
    }

    public Optional<Barista> buscarBarista(String identificacion) {
        return Optional.ofNullable(baristasPorId.get(identificacion));
    }

    //Sub
    public void suscribirBarista(String identificacion) {
        Barista b = baristasPorId.get(identificacion);
        if (b == null) throw new NoSuchElementException("No existe barista con id: " + identificacion);
        cooperativa.subscribe(b);
    }

    //Elim
    public void eliminarSuscripcion(String identificacion) {
        Barista b = baristasPorId.get(identificacion);
        if (b == null) throw new NoSuchElementException("No existe barista con id: " + identificacion);
        cooperativa.unsubscribe(b);
    }

    // DispLotes
    public void registrarNuevoLote(String varietal, String notasCata, String lugarOrigen,
                                  int alturaMsnm, String nombreProductor, double librasDisponibles) {

        LoteCafe lote = new LoteCafe(varietal, notasCata, lugarOrigen, alturaMsnm, nombreProductor, librasDisponibles);
        cooperativa.registrarNuevoLote(lote);
    }

    public List<Barista> listarBaristasRegistrados() {
        List<Barista> list = new ArrayList<>(baristasPorId.values());
        list.sort(Comparator.comparing(Barista::getIdentificacion));
        return list;
    }

    public int cantidadSuscriptores() {
        return cooperativa.getCantidadSuscriptores();
    }
}
