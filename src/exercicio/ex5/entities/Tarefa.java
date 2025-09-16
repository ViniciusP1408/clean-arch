package exercicio.ex5.entities;

public class Tarefa {
    public enum Status { PENDENTE, CONCLUIDA }

    private final String descricao;
    private Status status;

    public Tarefa(String descricao) {
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("Descrição inválida");
        this.descricao = descricao;
        this.status = Status.PENDENTE;
    }

    public String getDescricao() { return descricao; }
    public Status getStatus() { return status; }

    public void concluir() {
        if (status == Status.CONCLUIDA) throw new IllegalStateException("Tarefa já concluída");
        status = Status.CONCLUIDA;
    }
}
