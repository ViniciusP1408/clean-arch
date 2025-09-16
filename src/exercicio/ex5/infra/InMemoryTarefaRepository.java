package exercicio.ex5.infra;

import exercicio.ex5.entities.Tarefa;
import exercicio.ex5.repositories.TarefaRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTarefaRepository implements TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public void salvar(Tarefa tarefa) { tarefas.add(tarefa); }

    @Override
    public List<Tarefa> listarTodas() { return tarefas; }
}
