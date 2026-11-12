import java.time.LocalDate;
import java.util.Objects;

public class Voo {

    private Rota rota;
    private LocalDate data;
    private double precoBase;
    private int passageirosVendidos;

    private static final int CAPACIDADE = 150;

    public Voo(Rota rota, LocalDate data, double precoBase) {
        this.rota = rota;
        this.data = data;
        this.precoBase = precoBase;
        this.passageirosVendidos = 0;
    }

    public String getCodigo() {
        return "XAV" + rota.getCodigo();
    }

    public Rota getRota() {
        return rota;
    }

    public LocalDate getData() {
        return data;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public int vagasDisponiveis() {
        return CAPACIDADE - passageirosVendidos;
    }

    public boolean temVagas() {
        return vagasDisponiveis() > 0;
    }

    public boolean reservarVaga() {
        if (temVagas()) {
            passageirosVendidos++;
            return true;
        }
        return false;
    }

    public boolean podeSerSeguidoPor(Voo proximo) {
        if (proximo == null) {
            return false;
        }

        boolean mesmaCidade = rota.getDestino()
                .equals(proximo.getRota().getOrigem());

        boolean dataValida = data.equals(proximo.getData())
                || data.plusDays(1).equals(proximo.getData());

        return mesmaCidade && dataValida;
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }

        if (!(outro instanceof Voo)) {
            return false;
        }

        Voo voo = (Voo) outro;

        return Objects.equals(rota, voo.rota)
                && Objects.equals(data, voo.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rota, data);
    }

    @Override
    public String toString() {
        return "Voo: " + getCodigo()
                + " | Data: " + data
                + " | Preco: R$ " + precoBase
                + " | Vagas: " + vagasDisponiveis();
    }
}