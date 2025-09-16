package exercicio.ex5.usecases;

import exercicio.ex5.entities.Tarefa;
import exercicio.ex5.repositories.TarefaRepository;

public class ConcluirTarefaUseCase {
    public ConcluirTarefaUseCase(TarefaRepository repository) { }

    public void executar(Tarefa tarefa) {
        tarefa.concluir();
    }
}
