import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VooTest {

    private Rota rota;
    private Voo voo;

    @BeforeEach
    void preparar() {
        rota = mock(Rota.class, RETURNS_DEEP_STUBS);

        voo = new Voo(
                rota,
                LocalDate.of(2026, 11, 15),
                500.0
        );
    }

    @Test
    void deveCriarVooCorretamente() {
        assertEquals(rota, voo.getRota());
        assertEquals(LocalDate.of(2026, 11, 15),
                voo.getData());
        assertEquals(500.0, voo.getPrecoBase());
    }

    @Test
    void deveIniciarCom150Vagas() {
        assertEquals(150, voo.vagasDisponiveis());
        assertTrue(voo.temVagas());
    }

    @Test
    void deveReservarVaga() {
        assertTrue(voo.reservarVaga());
        assertEquals(149, voo.vagasDisponiveis());
    }

    @Test
    void naoDeveReservarVooLotado() {
        for (int i = 0; i < 150; i++) {
            voo.reservarVaga();
        }

        assertFalse(voo.temVagas());
        assertFalse(voo.reservarVaga());
        assertEquals(0, voo.vagasDisponiveis());
    }

    @Test
    void deveAceitarConexaoNoMesmoDia() {
        Rota outraRota = mock(
                Rota.class, RETURNS_DEEP_STUBS
        );

        when(outraRota.getOrigem())
                .thenReturn(rota.getDestino());

        Voo proximo = new Voo(
                outraRota,
                LocalDate.of(2026, 11, 15),
                300.0
        );

        assertTrue(voo.podeSerSeguidoPor(proximo));
    }

    @Test
    void deveAceitarConexaoNoDiaSeguinte() {
        Rota outraRota = mock(
                Rota.class, RETURNS_DEEP_STUBS
        );

        when(outraRota.getOrigem())
                .thenReturn(rota.getDestino());

        Voo proximo = new Voo(
                outraRota,
                LocalDate.of(2026, 11, 16),
                300.0
        );

        assertTrue(voo.podeSerSeguidoPor(proximo));
    }

    @Test
    void naoDeveAceitarConexaoDepoisDeDoisDias() {
        Voo proximo = new Voo(
                rota,
                LocalDate.of(2026, 11, 17),
                300.0
        );

        assertFalse(voo.podeSerSeguidoPor(proximo));
    }

    @Test
    void naoDeveAceitarConexaoComOrigemDiferente() {
        Rota outraRota = mock(
                Rota.class, RETURNS_DEEP_STUBS
        );

        Voo proximo = new Voo(
                outraRota,
                LocalDate.of(2026, 11, 16),
                300.0
        );

        assertFalse(voo.podeSerSeguidoPor(proximo));
    }

    @Test
    void naoDeveAceitarConexaoNula() {
        assertFalse(voo.podeSerSeguidoPor(null));
    }

    @Test
    void deveCompararVoosIguais() {
        Voo outro = new Voo(
                rota,
                LocalDate.of(2026, 11, 15),
                700.0
        );

        assertEquals(voo, outro);
        assertEquals(voo.hashCode(), outro.hashCode());
    }

    @Test
    void deveIdentificarVoosDiferentes() {
        Voo outro = new Voo(
                rota,
                LocalDate.of(2026, 11, 16),
                500.0
        );

        assertNotEquals(voo, outro);
    }

    @Test
    void deveGerarTextoDoVoo() {
        String texto = voo.toString();

        assertTrue(texto.contains("2026-11-15"));
        assertTrue(texto.contains("500.0"));
        assertTrue(texto.contains("150"));
    }
}