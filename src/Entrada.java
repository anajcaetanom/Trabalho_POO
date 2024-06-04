import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
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

        String msg = """
                Escolha uma opção:
                1) Cadastrar pessoa.
                2) Cadastrar empresa.
                3) Login.
                0) Sair.
                """;

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
        String msg = """
                Escolha uma opção:
                1) Seguir alguém.
                2) Fazer uma postagem.
                3) Exibir seu feed.
                0) Sair.
                """;

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
        System.out.println("\nCADASTRO DE PESSOA");
        String login = this.lerLinha("\nEscolha um login: ");

        while (sistema.buscarUsuario(login) != null) {
            login = this.lerLinha("\nLogin já utilizado. Escolha outro: ");
        }

        String nome = this.lerLinha("\nDigite seu nome: ");
        String senha = this.lerLinha("\nDigite sua senha: ");
        String cpf = this.lerLinha("\nDigite seu cpf: ");
        int dia = this.lerInteiro("\nDigite seu dia de nascimento: ");
        int mes = this.lerInteiro("\nDigite seu mes de nascimento: ");
        int ano = this.lerInteiro("\nDigite seu ano de nascimento: ");

        Pessoa p = new Pessoa(login, nome, senha, cpf, dia, mes, ano);
        sistema.novaPessoa(p);

        System.out.println("\n\nPessoa cadastrada!\n");
    }

    /**
     * Lê os dados de uma nova Empresa e a cadastra no sistema.
     * @param sistema: Um objeto da classe Sistema
     */
    public void cadEmpresa(Sistema sistema) {
        System.out.println("\nCADASTRO DE EMPRESA");
        String login = this.lerLinha("\nEscolha um login: ");

        while (sistema.buscarUsuario(login) != null) {
            login = this.lerLinha("\nLogin já utilizado. Escolha outro: ");
        }

        String nome = this.lerLinha("\nDigite seu nome: ");
        String senha = this.lerLinha("\nDigite sua senha: ");
        String cnpj = this.lerLinha("\nDigite seu cnpj: ");

        Empresa e = new Empresa(login, nome, senha, cnpj);
        sistema.novaEmpresa(e);

        System.out.println("\n\nEmpresa Cadastrada!\n");
    }

    /**
     * Lê os dados de uma nova Empresa e a cadastra no sistema.
     * @param usuario: Um objeto da classe Usuario
     */
    public void cadPostagem(Usuario usuario) {
        System.out.println("\nCriando post.");
        String nome_foto = this.lerLinha("\nDigite o nome da foto: ");
        String legenda = this.lerLinha("\nDigite a legenda da foto: ");
        System.out.println("\nDigite a data da foto.");
        int dia = this.lerInteiro("\nDia: ");
        int mes = this.lerInteiro("\nMês: ");
        int ano = this.lerInteiro("\nAno: ");

        String senha = this.lerLinha("\nConfirme sua senha: ");

        Data data_do_post = new Data(dia, mes, ano);

        usuario.postar(nome_foto, legenda, data_do_post, senha);

        System.out.println("\nFoto postada!\n");
    }

    public void login(Sistema sistema) {
        Usuario usuario;
        String username;
        int opcao;
        System.out.println("\nEFETUANDO LOGIN");
        String login = this.lerLinha("\nDigite seu login: ");

        if (sistema.buscarUsuario(login) != null) {
            usuario = sistema.buscarUsuario(login);
            String senha = this.lerLinha("\nDigite sua senha: ");
            if (usuario.validarAcesso(senha)) {
                System.out.println("\n\n*-*-*-*-*-* Login efetuado! *-*-*-*-*-*\n");
                opcao = menu2(sistema, usuario);

                while (opcao != -1) {

                    // Seguir
                    if (opcao == 1) {
                        System.out.println("\nSEGUIR ALGUÉM\n");
                        System.out.println("\nLISTA DE USERS");
                        sistema.listarUsuarios();
                        username = lerLinha("\nDigite o username do usuário que deseja seguir: ");
                        usuario.seguir(sistema.buscarUsuario(username));
                        System.out.println("\nSeguiu '" + username + "'.\n");
                    }

                    // Postar
                    if (opcao == 2) cadPostagem(usuario);

                    // Feed
                    if (opcao == 3) usuario.feed();

                    // Logout
                    if (opcao == 0) {
                        System.out.println("\nLogout efetuado.\n");
                        break;
                    }

                    opcao = menu2(sistema, usuario);
                }
            }
            else System.out.println("\nSenha incorreta.");
        }
        else System.out.println("Login não encontrado.\n");
    }


}
