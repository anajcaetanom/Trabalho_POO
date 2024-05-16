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

        String msg = "*********** Bem vinde ao Orkut! ***********\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar pessoa.\n" +
                "2) Cadastrar empresa.\n" +
                "3) Login.\n" +
                "0) Sair.\n";

        int option = this.lerInteiro(msg);

        while (option < 0 || option > 3) {
            System.out.println("Opção inválida. Digite algum dos números acima: ");
            System.out.println("Tente novamente: ");
            option = this.lerInteiro(msg);
        }

        return option;
    }

    /**
     * Imprime o menu secundário, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu2(Sistema sistema, Usuario usuario) {
        String msg = "*-*-*-*-*-* Login efetuado! *-*-*-*-*-*\n" +
                "Escolha uma opção:\n" +
                "1) Seguir alguém.\n" +
                "2) Fazer uma postagem.\n" +
                "3) Exibir seu feed.\n" +
                "0) Sair.\n";

        int option = this.lerInteiro(msg);

        while (option < 0 || option > 3) {
            System.out.println("Opção inválida. Digite algum dos números acima.");
            System.out.println("Tente novamente: ");
            option = this.lerInteiro(msg);
        }

        return option;
    }

    /**
     * Lê os dados de uma nova Pessoa e a cadastra no sistema.
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

        System.out.println("Pessoa cadastrada!\n");
    }

    /**
     * Lê os dados de uma nova Empresa e a cadastra no sistema.
     * @param sistema: Um objeto da classe Sistema
     */
    public void cadEmpresa(Sistema sistema) {
        String login = this.lerLinha("Escolha um login: ");

        while (sistema.buscarUsuario(login) != null) {
            login = this.lerLinha("Login já utilizado. Escolha outro: ");
        }

        String nome = this.lerLinha("Digite seu nome: ");
        String senha = this.lerLinha("Digite sua senha: ");
        String cnpj = this.lerLinha("Digite seu cnpj: ");

        Empresa e = new Empresa(login, nome, senha, cnpj);
        sistema.novaEmpresa(e);

        System.out.println("Empresa Cadastrada!\n");
    }

    /**
     * Lê os dados de uma nova Empresa e a cadastra no sistema.
     * @param usuario: Um objeto da classe Usuario
     */
    public void cadPostagem(Usuario usuario) {
        String nome_foto = this.lerLinha("Digite o nome da foto: ");
        String legenda = this.lerLinha("Digite a legenda da foto: ");
        System.out.println("Digite a data da foto.");
        int dia = this.lerInteiro("Dia: ");
        int mes = this.lerInteiro("Mês: ");
        int ano = this.lerInteiro("Ano: ");

        String senha = this.lerLinha("Confirme sua senha: ");

        Data data_do_post = new Data(dia, mes, ano);

        usuario.postar(nome_foto, legenda, data_do_post, senha);

        System.out.println("Foto postada!");
    }

    public void login(Sistema sistema) {
        Usuario usuario;
        String username;
        int opcao;

        String login = this.lerLinha("Digite seu login: ");

        if (sistema.buscarUsuario(login) != null) {
            usuario = sistema.buscarUsuario(login);
            String senha = this.lerLinha("Digite sua senha: ");
            if (usuario.validarAcesso(senha)) {
                opcao = menu2(sistema, usuario);

                while (opcao != 0) {

                    // Seguir
                    if (opcao == 1) {
                        System.out.println("Lista de usuários:");
                        sistema.listarUsuarios();
                        username = lerLinha("Digite o username do usuário que deseja seguir: ");
                        usuario.seguir(sistema.buscarUsuario(username));
                    }

                    // Postar
                    if (opcao == 2) cadPostagem(usuario);

                    // Feed
                    if (opcao == 3) usuario.feed();

                    opcao = menu2(sistema, usuario);
                }

                System.out.println("Senha incorreta.");
            }
        }

        System.out.println("Login não encontrado.");
    }


}
