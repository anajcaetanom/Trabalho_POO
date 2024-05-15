public class Data {
    private int dia, mes, ano;

    // Construtor
    Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

}
