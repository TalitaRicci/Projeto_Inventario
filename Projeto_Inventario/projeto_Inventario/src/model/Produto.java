package model;

public class Produto {
    private int produtoCodigo;
    private String nome;
    private double valor;
    private double quantidade;
    private String marca;

    public int getProdutoCodigo() {
        return produtoCodigo;
    }

    public void setProdutoCodigo(int produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Código Produto = " + produtoCodigo + "\n" +
                "Nome Produto = " + nome + "\n" +
                "Valor Produto = " + valor + "\n" +
                "Quantidade = " + quantidade + "\n" +
                "Marca do Produto = " + marca + "\n";
    }

    public boolean repor(double qtd){
        if(qtd > 0){
            quantidade += qtd;
            return true;
        }
        return false;
    }

    public boolean remover(double qtd){
        if(quantidade <= qtd){
            qtd -= quantidade;
            return true;
        }
        return false;
    }
}
