import java.nio.file.*;
import java.util.*;

/**
 * Lee los ficheros CSV y construye las listas de dominio.
 * Responsabilidad única: I/O y construcción de objetos.
 */
public class LectorDatos {

    public static List<Concierto> leerRepertorio(String fichero) throws Exception {
        List<String>   lineas    = Files.readAllLines(Paths.get(fichero));
        List<Concierto> resultado = new ArrayList<>();

        for (String linea : lineas) {
            linea = linea.replace("\"", "");
            String[] trozos = linea.split(",");
            String nombre        = trozos[0].trim();
            TipoConcierto tipo   = TipoConcierto.valueOf(trozos[1].trim().toUpperCase());
            resultado.add(new Concierto(nombre, tipo));
        }
        return resultado;
    }

    public static List<Actuacion> leerActuaciones(String fichero, List<Concierto> repertorio) throws Exception {
        List<String>    lineas    = Files.readAllLines(Paths.get(fichero));
        List<Actuacion> resultado = new ArrayList<>();

        for (String linea : lineas) {
            String[] trozos       = linea.split(",");
            int indiceConcierto   = Integer.parseInt(trozos[0].trim());
            int asistentes        = Integer.parseInt(trozos[1].trim());
            resultado.add(new Actuacion(repertorio.get(indiceConcierto), asistentes));
        }
        return resultado;
    }
}
