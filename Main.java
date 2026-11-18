import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        Cliente cliente = new Cliente("Lito", "Souza");

        Rota bhFor = Rota.criarRota(Cidade.BELO_HORIZONTE, Cidade.FORTALEZA);
        Rota forNat = Rota.criarRota(Cidade.FORTALEZA, Cidade.NATAL);

        Voo voo1 = new Voo(bhFor, LocalDate.of(2026, 12, 10), 500.0);
        Voo voo2 = new Voo(forNat, LocalDate.of(2026, 12, 10), 300.0);
        List<Voo> voos = Arrays.asList(voo1, voo2);

        Bilhete bilhete = agencia.gerarBilhete(cliente, voos);

        boolean vendido = agencia.venderBilhete(bilhete);

        System.out.println("Bilhete gerado: " + bilhete);
        System.out.println("Venda concluída: " + vendido);
    }
}