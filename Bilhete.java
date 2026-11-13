import java.util.ArrayList;
import java.util.List;

public class Bilhete {

    private Cliente cliente;
    private List<Voo> voos;

    public Bilhete(Cliente cliente) {
        this.cliente = cliente;
        this.voos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public boolean adicionarVoo(Voo voo) {
        if (voo == null) {
            return false;
        }

        // Se o bilhete está vazio, o primeiro voo é sempre aceito.
        if (voos.isEmpty()) {
            voos.add(voo);
            return true;
        }

        // Validação de conexão com o último voo já cadastrado.
        Voo ultimoVoo = voos.get(voos.size() - 1);

        boolean conexaoValida = ultimoVoo.getDestino().equals(voo.getOrigem());

        boolean dataValida = ultimoVoo.getData().equals(voo.getData())
                || ultimoVoo.getData().plusDays(1).equals(voo.getData());

        if (conexaoValida && dataValida) {
            voos.add(voo);
            return true;
        }

        return false;
    }

    public Cidade getOrigem() {
        if (voos.isEmpty()) {
            return null;
        }
        return voos.get(0).getOrigem();
    }

    public Cidade getDestino() {
        if (voos.isEmpty()) {
            return null;
        }
        return voos.get(voos.size() - 1).getDestino();
    }

    public double calcularPrecoVenda() {
        double total = 0.0;
        for (Voo voo : voos) {
            total += voo.getPrecoBase();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Bilhete: " + getOrigem().getNome() + " -> " + getDestino().getNome()
                + " | Voos: " + voos.size()
                + " | Valor total: R$ " + calcularPrecoVenda();
    }
}