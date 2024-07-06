import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Data {
    private int dia, mes, ano;

    // Construtor
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // Construtor parte 3 do trabalho
    public Data(BufferedReader br) {
        try {
            this.dia = Integer.parseInt(br.readLine());
            this.mes = Integer.parseInt(br.readLine());
            this.ano = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Erro ao carregar data.");
        }
    }

    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

    public void write_data(BufferedWriter bw) {
        try {
            bw.write(this.dia + "\n");
            bw.write(this.mes + "\n");
            bw.write(this.ano + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao escrever a data.");
        }
    }




}
