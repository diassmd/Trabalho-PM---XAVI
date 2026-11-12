Import java.util.list;
public class Bilhete{
    private Cliente cliente;
    private List<Voo> voos;

    public bilhete(Cliente cliente){
        this.cliente = cliente;
        List<Voo> voos = new Lista<>;
    }

    public void getCliente(){
        return cliente;
    }

    public void adicionarVoo(Voo voo){
        voos.add(voo);
    }

    public boolean voosVazios(){
        return voos.isEmpty();
    }

    public double calcularVenda(){
        Voo aux = new Voo;
        double valor;
        for(int i = 1; i <= voos.size(); i++){
            aux = voos.get(i);
            valor += aux.getValor();
        }

        return valor;

    }
}