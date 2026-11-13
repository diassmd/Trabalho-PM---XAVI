import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VooTest {

    private Rota rota;
    private Voo voo;

    @BeforeEach
    void preparar() {
        rota = new Rota(Cidade.BELO_HORIZONTE, Cidade.FORTALEZA);
        voo = new Voo(rota, LocalDate.of(2026, 11, 15), 500.0);
    }

    @Test
    void deveCriarVooCorretamente() {
        assertEquals(rota, voo.getRota());
        assertEquals(LocalDate.of(2026, 11, 15), voo.getData());
        assertEquals(500.0, voo.getPrecoBase());
        assertEquals("XAV1320", voo.getCodigo());
    }

    @Test
    void deveIniciarCom150Vagas() {
        assertEquals(150, voo.vagasRestantes());
        assertTrue(voo.temVagas());
    }

    @Test
    void deveReservarVaga() {
        assertTrue(voo.reservarVaga());
        assertEquals(149, voo.vagasRestantes());
    }

    @Test
    void naoDeveReservarVooLotado() {
        for (int i = 0; i < 150; i++) {
            voo.reservarVaga();
        }

        assertFalse(voo.temVagas());
        assertFalse(voo.reservarVaga());
        assertEquals(0, voo.vagasRestantes());
    }

    @Test
    void deveRetornarOrigemCorreta() {
        assertEquals(Cidade.BELO_HORIZONTE, voo.getOrigem());
    }

    @Test
    void deveRetornarDestinoCorreto() {
        assertEquals(Cidade.FORTALEZA, voo.getDestino());
    }

    @Test
    void deveRetornarCodigoRota() {
        assertEquals("1320", voo.getCodigoRota());
    }

    @Test
    void deveRetornarCapacidade() {
        assertEquals(150, voo.getCapacidade());
    }

    @Test
    void deveIniciarComZeroPassageirosVendidos() {
        assertEquals(0, voo.getPassageirosVendidos());
    }

    @Test
    void deveIncrementarPassageirosVendidos() {
        voo.reservarVaga();
        voo.reservarVaga();
        assertEquals(2, voo.getPassageirosVendidos());
    }

    @Test
    void deveCompararVoosIguais() {
        Voo outro = new Voo(rota, LocalDate.of(2026, 11, 15), 700.0);

        assertEquals(voo, outro);
        assertEquals(voo.hashCode(), outro.hashCode());
    }

    @Test
    void deveIdentificarVoosDiferentes() {
        Voo outro = new Voo(rota, LocalDate.of(2026, 11, 16), 500.0);

        assertNotEquals(voo, outro);
    }

    @Test
    void deveGerarTextoDoVoo() {
        String texto = voo.toString();

        assertTrue(texto.contains("XAV1320"));
        assertTrue(texto.contains("2026-11-15"));
        assertTrue(texto.contains("500.0"));
        assertTrue(texto.contains("150"));
    }
}