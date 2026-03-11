import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests unitarios de Tarea A:
 * Verifican importe y créditos sin comparar texto final.
 */
public class TarifaConciertoTest {

    // ── HEAVY bajo umbral (≤500) ────────────────────────────────────────────
    @Test
    public void heavy_bajo_umbral_importe() {
        TarifaConcierto tarifa = new TarifaHeavy();
        assertEquals(4000d, tarifa.importe(300), 0.001);
    }

    @Test
    public void heavy_bajo_umbral_creditos() {
        TarifaConcierto tarifa = new TarifaHeavy();
        // max(300-500,0)=0  + 300/5=60
        assertEquals(60, tarifa.creditos(300));
    }

    // ── HEAVY sobre umbral (>500) ───────────────────────────────────────────
    @Test
    public void heavy_sobre_umbral_importe() {
        TarifaConcierto tarifa = new TarifaHeavy();
        // 4000 + 20*(2000-500) = 4000+30000 = 34000
        assertEquals(34000d, tarifa.importe(2000), 0.001);
    }

    @Test
    public void heavy_sobre_umbral_creditos() {
        TarifaConcierto tarifa = new TarifaHeavy();
        // (2000-500) + 2000/5 = 1500+400 = 1900
        assertEquals(1900, tarifa.creditos(2000));
    }

    // ── ROCK bajo umbral (≤1000) ────────────────────────────────────────────
    @Test
    public void rock_bajo_umbral_importe() {
        TarifaConcierto tarifa = new TarifaRock();
        assertEquals(3000d, tarifa.importe(800), 0.001);
    }

    @Test
    public void rock_bajo_umbral_creditos() {
        TarifaConcierto tarifa = new TarifaRock();
        // max(800-1000,0) = 0
        assertEquals(0, tarifa.creditos(800));
    }

    // ── ROCK sobre umbral (>1000) ───────────────────────────────────────────
    @Test
    public void rock_sobre_umbral_importe() {
        TarifaConcierto tarifa = new TarifaRock();
        // 3000 + 30*(1200-1000) = 3000+6000 = 9000
        assertEquals(9000d, tarifa.importe(1200), 0.001);
    }

    @Test
    public void rock_sobre_umbral_creditos() {
        TarifaConcierto tarifa = new TarifaRock();
        // 1200-1000 = 200
        assertEquals(200, tarifa.creditos(1200));
    }
}
