import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Data implements Comparable<Data> {
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

    // Métodos
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

    /**
     *
     * @param d: recebe uma data para comparar com a atual.
     * @return 1 caso a Data d seja mais recente, -1 caso não seja e 0 se for igual.
     */
    public int compareTo(Data d) {
        if (d.getAno() < this.ano) return 1;
        else if (d.getAno() > this.ano) return -1;
        else if (d.getMes() < this.mes) return 1;
        else if (d.getMes() > this.mes) return -1;
        else if (d.getDia() < this.dia) return 1;
        else if (d.getDia() > this.dia) return -1;

        else return 0;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }




}
