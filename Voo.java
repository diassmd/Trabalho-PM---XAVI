import java.time.LocalDate;
import java.util.Objects;

public class Voo {

    private static final int CAPACIDADE = 150;

    private Rota rota;
    private LocalDate data;
    private double precoBase;
    private int passageirosVendidos;

    public Voo(Rota rota, LocalDate data, double precoBase) {
        this.rota = rota;
        this.data = data;
        this.precoBase = precoBase;
        this.passageirosVendidos = 0;
    }

    public Rota getRota() {
        return rota;
    }

    public Cidade getOrigem() {
        return rota.getOrigem();
    }

    public Cidade getDestino() {
        return rota.getDestino();
    }

    public String getCodigoRota() {
        return rota.getCodigo();
    }

    public String getCodigo() {
        return "XAV" + rota.getCodigo();
    }

    public LocalDate getData() {
        return data;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public int getCapacidade() {
        return CAPACIDADE;
    }

    public int getPassageirosVendidos() {
        return passageirosVendidos;
    }

    public boolean temVagas() {
        return vagasRestantes() > 0;
    }

    public int vagasRestantes() {
        return CAPACIDADE - passageirosVendidos;
    }

    public boolean reservarVaga() {
        if (temVagas()) {
            passageirosVendidos++;
            return true;
        }
        return false;
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
        return Objects.equals(rota, voo.rota) && Objects.equals(data, voo.data);
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
                + " | Vagas restantes: " + vagasRestantes();
    }
}