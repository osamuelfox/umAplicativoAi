package dev.samuel.teste.agenda.model;

public class Calculadora {

    private String peso;
    private String altura;
    private String resultado;

    public Calculadora() {
    }

    public Calculadora(String peso, String altura, String resultado) {
        this.peso = peso;
        this.altura = altura;
        this.resultado = resultado;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Calculadora{" +
                "peso='" + peso + '\'' +
                ", altura='" + altura + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
