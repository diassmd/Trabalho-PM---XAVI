import java.util.List;

public class Agencia {

    public Bilhete gerarBilhete(Cliente cliente, List<Voo> voos) {
        if (cliente == null || voos == null || voos.isEmpty()) {
            return null;
        }

        Bilhete bilhete = new Bilhete(cliente);

        for (Voo voo : voos) {
            if (!bilhete.adicionarVoo(voo)) {
                return null;
            }
        }

        return bilhete;
    }

    public boolean venderBilhete(Bilhete bilhete) {
        if (bilhete == null || bilhete.getVoos().isEmpty()) {
            return false;
        }

        Cliente cliente = bilhete.getCliente();

        if (cliente.getHistorico().contains(bilhete)) {
            return false;
        }

       for (Voo voo : bilhete.getVoos()) {
            if (!voo.temVagas()) {
                return false;
            }
        }

        for (Voo voo : bilhete.getVoos()) {
            voo.reservarVaga();
        }

        cliente.adicionarBilhete(bilhete);
        return true;
    }
}