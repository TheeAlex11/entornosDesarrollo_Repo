/**
 * Representa un concierto del repertorio.
 * Contiene su nombre, tipo y la tarifa asociada (Strategy).
 */
public class Concierto {

    private final String          nombre;
    private final TipoConcierto   tipo;
    private final TarifaConcierto tarifa;

    public Concierto(String nombre, TipoConcierto tipo) {
        this.nombre = nombre;
        this.tipo   = tipo;
        this.tarifa = fabricarTarifa(tipo);
    }

    private static TarifaConcierto fabricarTarifa(TipoConcierto tipo) {
        switch (tipo) {
            case HEAVY: return new TarifaHeavy();
            case ROCK:  return new TarifaRock();
            default:    throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }

    public String getNombre() { return nombre; }
    public TipoConcierto getTipo() { return tipo; }
    public TarifaConcierto getTarifa() { return tarifa; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ")";
    }
}
