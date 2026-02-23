package co.edu.udistrital.cafe.model;

import co.edu.udistrital.cafe.observer.Observer;

import java.util.Objects;

public class Barista implements Observer<LoteCafe> {
    private final String nombre;
    private final String identificacion;

    public Barista(String nombre, String identificacion) {
        if (isBlank(nombre) || isBlank(identificacion)) {
            throw new IllegalArgumentException("Nombre e identificación son obligatorios.");
        }
        this.nombre = nombre.trim();
        this.identificacion = identificacion.trim();
    }

    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }

    @Override
    public void update(LoteCafe lote) {
        // Notis
        System.out.println("📣 Notificación para Barista " + nombre + " (" + identificacion + "):");
        System.out.println("   Nuevo microlote disponible:");
        System.out.println("   - Varietal: " + lote.getVarietal());
        System.out.println("   - Notas: " + lote.getNotasCata());
        System.out.println("   - Origen: " + lote.getLugarOrigen());
        System.out.println("   - Altura: " + lote.getAlturaMsnm() + " msnm");
        System.out.println("   - Productor: " + lote.getNombreProductor());
        System.out.println("   - Cantidad: " + lote.getLibrasDisponibles() + " lb");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Barista{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barista)) return false;
        Barista barista = (Barista) o;
        return identificacion.equals(barista.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion);
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
