/**
 * Representa una actuación concreta: un Concierto con un número de asistentes.
 * El Concierto se referencia directamente (no por índice).
 */
public class Actuacion {

    private final Concierto concierto;
    private final int       asistentes;

    public Actuacion(Concierto concierto, int asistentes) {
        this.concierto  = concierto;
        this.asistentes = asistentes;
    }

    public Concierto getConcierto() { return concierto; }
    public int getAsistentes()      { return asistentes; }

    public double importe() {
        return concierto.getTarifa().importe(asistentes);
    }

    public int creditos() {
        return concierto.getTarifa().creditos(asistentes);
    }

    @Override
    public String toString() {
        return concierto.getNombre() + " - " + asistentes + " asistentes";
    }
}
