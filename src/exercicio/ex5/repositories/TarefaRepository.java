package exercicio.ex5.repositories;

import exercicio.ex5.entities.Tarefa;

import java.util.List;

public interface TarefaRepository {
    void salvar(Tarefa tarefa);
    List<Tarefa> listarTodas();
}
