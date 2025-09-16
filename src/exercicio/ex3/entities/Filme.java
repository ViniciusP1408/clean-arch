package exercicio.ex3.entities;

public class Filme {
    private final String titulo;
    private final String genero;
    private final int ano;

    public Filme(String titulo, String genero, int ano) {
        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("Título inválido");
        if (genero == null || genero.isBlank()) throw new IllegalArgumentException("Gênero inválido");
        if (ano <= 1800) throw new IllegalArgumentException("Ano inválido");
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getAno() { return ano; }
}
