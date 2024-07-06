


public class Main {

    public static void main(String[] args) {
        Entrada io = new Entrada();
        Sistema s = new Sistema();

        s.read_txt_file();

        System.out.print("\n\n*********** Bem vinde ao Orkut! ***********\n");

        int op = io.menu1();

        while (op != 0) {

            if (op == 1) {
                io.cadPessoa(s);
                s.write_txt_file();

            } else if (op == 2) {
                io.cadEmpresa(s);
                s.write_txt_file();

            } else if (op == 3) {
                io.login(s);
            }

            op = io.menu1();
        }

        System.out.println("\nSaiu do Orkut. tchauuuu <3");

    }
}