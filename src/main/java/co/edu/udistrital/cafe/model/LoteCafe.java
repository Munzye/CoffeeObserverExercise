package co.edu.udistrital.cafe.model;

import java.util.Objects;

public class LoteCafe {
    private final String varietal;        
    private final String notasCata;       
    private final String lugarOrigen;     
    private final int alturaMsnm;         
    private final String nombreProductor; 
    private final double librasDisponibles;

    public LoteCafe(String varietal, String notasCata, String lugarOrigen,
                    int alturaMsnm, String nombreProductor, double librasDisponibles) {

        if (isBlank(varietal) || isBlank(notasCata) || isBlank(lugarOrigen) || isBlank(nombreProductor)) {
            throw new IllegalArgumentException("Ningún campo de texto puede ser vacío.");
        }
        if (alturaMsnm <= 0) throw new IllegalArgumentException("La altura debe ser > 0.");
        if (librasDisponibles <= 0) throw new IllegalArgumentException("Las libras disponibles deben ser > 0.");

        this.varietal = varietal.trim();
        this.notasCata = notasCata.trim();
        this.lugarOrigen = lugarOrigen.trim();
        this.alturaMsnm = alturaMsnm;
        this.nombreProductor = nombreProductor.trim();
        this.librasDisponibles = librasDisponibles;
    }

    public String getVarietal() { return varietal; }
    public String getNotasCata() { return notasCata; }
    public String getLugarOrigen() { return lugarOrigen; }
    public int getAlturaMsnm() { return alturaMsnm; }
    public String getNombreProductor() { return nombreProductor; }
    public double getLibrasDisponibles() { return librasDisponibles; }

    @Override
    public String toString() {
        return "LoteCafe{" +
                "varietal='" + varietal + '\'' +
                ", notasCata='" + notasCata + '\'' +
                ", lugarOrigen='" + lugarOrigen + '\'' +
                ", alturaMsnm=" + alturaMsnm +
                ", nombreProductor='" + nombreProductor + '\'' +
                ", librasDisponibles=" + librasDisponibles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoteCafe)) return false;
        LoteCafe loteCafe = (LoteCafe) o;
        return alturaMsnm == loteCafe.alturaMsnm
                && Double.compare(loteCafe.librasDisponibles, librasDisponibles) == 0
                && varietal.equals(loteCafe.varietal)
                && notasCata.equals(loteCafe.notasCata)
                && lugarOrigen.equals(loteCafe.lugarOrigen)
                && nombreProductor.equals(loteCafe.nombreProductor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(varietal, notasCata, lugarOrigen, alturaMsnm, nombreProductor, librasDisponibles);
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
