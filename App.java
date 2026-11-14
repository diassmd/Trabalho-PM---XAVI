import java.util.Scanner;

public class App {
    static Scanner leitor = new Scanner(System.in);
    
    public void MostrarMenu() {
        cabecalho();
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Gerar lista de rotas");
        System.out.println("4. Cadastrar voos");
        System.out.println("5. Procurar voos");
        System.out.println("6. Criar bilhete");
        System.out.println("7. Comprar bilhete");
        System.out.println("8. Sair");
        System.out.print("Selecione uma opção: ");
        return Integer.parseInt(leitor.nextLine());
    }
    void cadastrarCliente() {
    }
    void gerarRotas() {
    }
    void cadastrarVoos() {
    }
    void procurarVoos() {
    }
    void criarBilhete() {
    }
    void comprarBilhete() {
    }
}
