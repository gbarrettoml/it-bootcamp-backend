package main;

public class Pereciveis extends Produto {

    private int diasParaVencer;

    public Pereciveis(String nome, double preco, int diasParaVencer) {
        super(nome, preco);
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public String toString() {
        return "Pereciveis{" +
                "diasParaVencer=" + diasParaVencer +
                '}';
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcular(int quantidadeDeProdutos) {
        if(diasParaVencer == 1) return (this.getPreco() * quantidadeDeProdutos) / 4;
        if(diasParaVencer == 2) return (this.getPreco() * quantidadeDeProdutos) / 3;
        if(diasParaVencer == 3) return (this.getPreco() * quantidadeDeProdutos) / 2;
        return this.getPreco() * quantidadeDeProdutos;
    }
}
