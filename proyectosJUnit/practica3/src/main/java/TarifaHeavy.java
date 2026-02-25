/**
 * Tarifa para conciertos de tipo HEAVY.
 * Base: 4000€. Por encima de 500 asistentes: +20€/asistente.
 * Créditos: asistentes sobre 500 + asistentes/5.
 */
public class TarifaHeavy implements TarifaConcierto {

    private static final double IMPORTE_BASE   = 4000d;
    private static final int    UMBRAL         = 500;
    private static final int    PLUS_IMPORTE   = 20;
    private static final int    DIVISOR_CREDITOS = 5;

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
        return Math.max(asistentes - UMBRAL, 0) + (asistentes / DIVISOR_CREDITOS);
    }
}
