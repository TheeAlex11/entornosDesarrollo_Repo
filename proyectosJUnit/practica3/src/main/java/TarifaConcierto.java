/**
 * Estrategia de cálculo de tarifa para un concierto.
 * Permite eliminar el switch/condicional por tipo mediante polimorfismo.
 */
public interface TarifaConcierto {
    double importe(int asistentes);
    int creditos(int asistentes);
}
