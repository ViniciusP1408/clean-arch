package exercicio.ex1.entities;

public class Aluno {
    private final String nome;
    private final String matricula;
    private final String curso;

    public Aluno(String nome, String matricula, String curso) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido");
        if (matricula == null || matricula.isBlank()) throw new IllegalArgumentException("Matrícula inválida");
        if (curso == null || curso.isBlank()) throw new IllegalArgumentException("Curso inválido");
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }
}
