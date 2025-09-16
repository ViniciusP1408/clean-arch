package exercicio.ex2.entities;

public class Funcionario {
    private final String nome;
    private final String cargo;
    private final double salario;

    public Funcionario(String nome, String cargo, double salario) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido");
        if (cargo == null || cargo.isBlank()) throw new IllegalArgumentException("Cargo inválido");
        if (salario < 0) throw new IllegalArgumentException("Salário inválido");
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public double getSalario() { return salario; }
}
