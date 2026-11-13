import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int proximoRegistro = 1;

    private String nome;
    private String sobrenome;
    private int numeroRegistro;
    private List<Bilhete> historico;

    public Cliente(String nome, String sobrenome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (sobrenome == null) {
            throw new IllegalArgumentException("Sobrenome não pode ser vazio.");
        }
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroRegistro = proximoRegistro++;
        this.historico = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public List<Bilhete> getHistorico() {
        return new ArrayList<>(historico);
    }

    public void adicionarBilhete(Bilhete bilhete) {
        if (bilhete != null) {
            historico.add(bilhete);
        }
    }

    public double calcularTotalGasto() {
        double total = 0.0;
        for (Bilhete bilhete : historico) {
            total += bilhete.calcularPrecoVenda();
        }
        return total;
    }
}
