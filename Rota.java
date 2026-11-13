import java.util.Arrays;
import java.util.List;

public class Rota {
    private final String codigo;
    private final Cidade origem;
    private final Cidade destino;

    public Rota(Cidade origem, Cidade destino) {
        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Origem e destino são obrigatórios.");
        }
        if (origem == destino) {
            throw new IllegalArgumentException("Origem e destino devem ser diferentes.");
        }
        this.origem = origem;
        this.destino = destino;
        this.codigo = origem.getCodigo() + destino.getCodigo();
    }

    public static Rota criarRota(Cidade origem, Cidade destino) {
        return new Rota(origem, destino);
    }

    public static List<Cidade> cidadesAtendidas() {
        return Arrays.asList(Cidade.values());
    }

    public String getCodigo() {
        return codigo;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public String getRotaCompleta() {
        return origem.getNome() + " -> " + destino.getNome();
    }
}