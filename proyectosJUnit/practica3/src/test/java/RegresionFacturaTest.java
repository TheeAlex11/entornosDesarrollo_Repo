import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

/**
 * Test de regresión (Tarea E): verifica que la salida completa
 * es idéntica a la del código original con los datos de ejemplo.
 */
public class RegresionFacturaTest {

    @Test
    public void salida_completa_identica_al_original() {
        // Repertorio original
        List<Concierto> repertorio = Arrays.asList(
            new Concierto("Tributo Robe",    TipoConcierto.HEAVY),
            new Concierto("Homenaje Queen",  TipoConcierto.ROCK),
            new Concierto("Magia Knoppler",  TipoConcierto.ROCK),
            new Concierto("Demonios Rojos",  TipoConcierto.HEAVY)
        );

        // Actuaciones originales: {0,2000},{2,1200},{0,950},{3,1140}
        List<Actuacion> actuaciones = Arrays.asList(
            new Actuacion(repertorio.get(0), 2000),
            new Actuacion(repertorio.get(2), 1200),
            new Actuacion(repertorio.get(0),  950),
            new Actuacion(repertorio.get(3), 1140)
        );

        String resultado = new GeneradorFactura("Ayuntamiento de Badajoz", actuaciones).generar();

        // Salida esperada calculada manualmente del FacturadorBase original:
        // Tributo Robe  heavy 2000 → 4000+20*1500=34000   créditos: 1500+400=1900
        // Magia Knoppler rock 1200 → 3000+30*200=9000     créditos: 200
        // Tributo Robe  heavy  950 → 4000+20*450=13000    créditos: 450+190=640
        // Demonios Rojos heavy 1140→ 4000+20*640=16800    créditos: 640+228=868
        // base=72800  iva=15288  total=88088  creditos=3608
        String esperado =
            "FACTURA DE ACTUACIONES\n" +
            "Cliente: Ayuntamiento de Badajoz\n" +
            "\tConcierto: Tributo Robe\n" +
            "\t\tAsistentes: 2000\n" +
            "\tConcierto: Magia Knoppler\n" +
            "\t\tAsistentes: 1200\n" +
            "\tConcierto: Tributo Robe\n" +
            "\t\tAsistentes: 950\n" +
            "\tConcierto: Demonios Rojos\n" +
            "\t\tAsistentes: 1140\n" +
            "BASE IMPONIBLE: 72800.0 euros\n" +
            "IVA (21%): 15288.00 euros\n" +
            "TOTAL FACTURA: 88088.00 euros\n" +
            "Créditos obtenidos: 3608\n";

        assertEquals(esperado, resultado);
    }
}
