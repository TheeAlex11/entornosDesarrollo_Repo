import java.util.List;

/**
 * Punto de entrada. Actúa únicamente como orquestador:
 * lee datos → genera factura → imprime.
 */
public class Facturador {

    static final String CLIENTE = "Ayuntamiento de Badajoz";

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Uso: java Facturador conciertos.csv datos.csv");
            return;
        }

        List<Concierto> repertorio  = LectorDatos.leerRepertorio(args[0]);
        List<Actuacion> actuaciones = LectorDatos.leerActuaciones(args[1], repertorio);

        String factura = new GeneradorFactura(CLIENTE, actuaciones).generar();
        System.out.print(factura);
    }
}
