import java.io.*;
import java.util.*;

public class ClasificadorBasura {
    public static void main(String[] args) throws IOException {
        String inputFile = "basura.txt";
        String organicaFile = "organica.txt";
        String plasticosFile = "plasticos.txt";
        String generalFile = "general.txt";

        // Contadores
        Integer contOrganica = 0;
        Integer contPlastico = 0;
        Integer contGeneral = 0;
        

        // Pesos
        Double pesoOrganica = 0.0;
        Double pesoPlastico = 0.0;
        Double pesoGeneral = 0.0;

        // Leer fichero de entrada
        BufferedReader bufferedreader = new BufferedReader(new FileReader(inputFile));
        String linea;

        // Crear ficheros de salida
        PrintWriter organicaLines = new PrintWriter(new FileWriter(organicaFile));
        PrintWriter plasticosLines = new PrintWriter(new FileWriter(plasticosFile));
        PrintWriter generalLines = new PrintWriter(new FileWriter(generalFile));

        // Procesar cada línea del fichero
        while ((linea = bufferedreader.readLine()) != null) {
            String[] datos = linea.split(",");
            String codigo = datos[0];
            String descripcion = datos[1];
            Double peso = Double.parseDouble(datos[2]);

            switch (codigo) {
                case "O":
                    String fechaCaducidad = datos[3];
                    organicaLines.println(codigo + "," + descripcion + "," + peso + "," + fechaCaducidad);
                    contOrganica++;
                    pesoOrganica += peso;
                    break;
                case "P":
                    String tipoPlastico = datos[3];
                    plasticosLines.println(codigo + "," + descripcion + "," + peso + "," + tipoPlastico);
                    contPlastico++;
                    pesoPlastico += peso;
                    break;
                case "G":
                    String origen = datos[3];
                    generalLines.println(codigo + "," + descripcion + "," + peso + "," + origen);
                    contGeneral++;
                    pesoGeneral += peso;
                    break;
                default:
                    System.out.println("Código de basura desconocido: " + codigo);
            }

            
        }

        // Cerrar ficheros
        bufferedreader.close();
        organicaLines.close();
        plasticosLines.close();
        generalLines.close();

        // Informe final
        System.out.println("Informe de clasificación de basura:");
        System.out.println("------------------------------------");
        System.out.println("Orgánica: " + contOrganica + " elementos, " + pesoOrganica + " kg");
        System.out.printf("Plásticos: %d elementos, %.1f kg%n", contPlastico, pesoPlastico);
        System.out.println("General: " + contGeneral + " elementos, " + pesoGeneral + " kg");
        System.out.println("Total: " + (contOrganica + contPlastico + contGeneral) + " elementos, " + (pesoOrganica + pesoPlastico + pesoGeneral) + " kg");
    }
}

