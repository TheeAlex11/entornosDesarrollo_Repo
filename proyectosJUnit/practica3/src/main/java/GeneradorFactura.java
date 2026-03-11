import java.util.List;

/**
 * Responsable de generar la factura en texto a partir de un cliente
 * y una lista de actuaciones.
 * Separa la responsabilidad de presentación del resto de la lógica.
 */
public class GeneradorFactura {

    private static final double PORCENTAJE_IVA = 0.21;

    private final String          cliente;
    private final List<Actuacion> actuaciones;

    public GeneradorFactura(String cliente, List<Actuacion> actuaciones) {
        this.cliente     = cliente;
        this.actuaciones = actuaciones;
    }

    public String generar() {
        double totalBase = 0d;
        int    creditos  = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("FACTURA DE ACTUACIONES\n");
        sb.append("Cliente: ").append(cliente).append("\n");

        for (Actuacion actuacion : actuaciones) {
            double importe = actuacion.importe();
            totalBase += importe;
            creditos  += actuacion.creditos();

            sb.append("\tConcierto: ").append(actuacion.getConcierto().getNombre()).append("\n");
            sb.append("\t\tAsistentes: ").append(actuacion.getAsistentes()).append("\n");
        }

        sb.append("BASE IMPONIBLE: ").append(totalBase).append(" euros\n");
        sb.append(String.format("IVA (21%%): %.2f euros%n", totalBase * PORCENTAJE_IVA));
        sb.append(String.format("TOTAL FACTURA: %.2f euros%n", totalBase * (1 + PORCENTAJE_IVA)));
        sb.append("Créditos obtenidos: ").append(creditos).append("\n");

        return sb.toString();
    }
}
