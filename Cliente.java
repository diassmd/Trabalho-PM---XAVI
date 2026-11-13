import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

    private static int proximoRegistro = 1;

    private String nome;
    private String sobrenome;
    private int numeroRegistro;
    private List<Bilhete> historico;

    public Cliente(String nome, String sobrenome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (sobrenome == null || sobrenome.trim().isEmpty()) {
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

    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }
        if (!(outro instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) outro;
        return numeroRegistro == cliente.numeroRegistro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroRegistro);
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " " + sobrenome
                + " | Registro: " + numeroRegistro
                + " | Bilhetes: " + historico.size()
                + " | Total gasto: R$ " + calcularTotalGasto();
    }
}