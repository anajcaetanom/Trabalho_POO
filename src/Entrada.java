import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior e Ana Julia C. Martins
 **/
public class Entrada {
    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt na pasta corrente, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
            // NAO ALTERE A LOCALICAÇÃO DO ARQUIVO!!
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu1() {

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar pessoa.\n" +
                "2) Cadastrar empresa.\n" +
                "3) Login.\n" +
                "0) Sair.\n";

        int option = this.lerInteiro(msg);

        while (option < 0 || option > 3) {
            System.out.println("Opção inválida. Tente novamente: ");
            option = this.lerInteiro(msg);
        }

        return option;
    }

    public int menu2(Sistema sistema, Usuario usuario) {

    }

    /**
     * Lê os dados de uma nova Pessoa e cadastra-a no sistema.
     * @param sistema: Um objeto da classe Sistema
     */
    public void cadPessoa(Sistema sistema) {
        String login = this.lerLinha("Escolha um login: ");

        while (sistema.buscarUsuario(login) != null) {
            login = this.lerLinha("Login já utilizado. Escolha outro: ");
        }

        String nome = this.lerLinha("Digite seu nome: ");
        String senha = this.lerLinha("Digite sua senha: ");
        String cpf = this.lerLinha("Digite seu cpf: ");
        String bio = this.lerLinha("Digite sua bio: ");
        int dia = this.lerInteiro("Digite seu dia de nascimento: ");
        int mes = this.lerInteiro("Digite seu mes de nascimento: ");
        int ano = this.lerInteiro("Digite seu ano de nascimento: ");

        Pessoa p = new Pessoa(login, nome, senha, cpf, bio, dia, mes, ano);
        sistema.novaPessoa(p);
    }

}
