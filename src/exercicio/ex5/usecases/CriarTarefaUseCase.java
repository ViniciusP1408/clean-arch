package exercicio.ex5.usecases;

import exercicio.ex5.entities.Tarefa;
import exercicio.ex5.repositories.TarefaRepository;

public class CriarTarefaUseCase {
    private final TarefaRepository repository;

    public CriarTarefaUseCase(TarefaRepository repository) { this.repository = repository; }

    public void executar(String descricao) {
        repository.salvar(new Tarefa(descricao));
    }
}
