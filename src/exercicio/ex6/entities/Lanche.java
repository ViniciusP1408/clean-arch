package exercicio.ex6.entities;

public class Lanche {
    private final String nome;
    private final double preco;
    private boolean disponivel;

    public Lanche(String nome, double preco, boolean disponivel) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido");
        if (preco < 0) throw new IllegalArgumentException("Preço inválido");
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
