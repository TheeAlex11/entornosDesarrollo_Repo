/**
 * Tarifa para conciertos de tipo ROCK.
 * Base: 3000€. Por encima de 1000 asistentes: +30€/asistente.
 * Créditos: asistentes sobre 1000.
 */
public class TarifaRock implements TarifaConcierto {

    private static final double IMPORTE_BASE = 3000d;
    private static final int    UMBRAL       = 1000;
    private static final int    PLUS_IMPORTE = 30;

    @Override
    public double importe(int asistentes) {
        double total = IMPORTE_BASE;
        if (asistentes > UMBRAL) {
            total += PLUS_IMPORTE * (asistentes - UMBRAL);
        }
        return total;
    }

    @Override
    public int creditos(int asistentes) {
        return Math.max(asistentes - UMBRAL, 0);
    }
}
