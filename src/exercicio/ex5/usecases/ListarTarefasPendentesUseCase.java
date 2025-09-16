package exercicio.ex5.usecases;

import exercicio.ex5.entities.Tarefa;
import exercicio.ex5.repositories.TarefaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ListarTarefasPendentesUseCase {
    private final TarefaRepository repository;

    public ListarTarefasPendentesUseCase(TarefaRepository repository) { this.repository = repository; }

    public List<Tarefa> executar() {
        return repository.listarTodas().stream()
                .filter(t -> t.getStatus() == Tarefa.Status.PENDENTE)
                .collect(Collectors.toList());
    }
}
