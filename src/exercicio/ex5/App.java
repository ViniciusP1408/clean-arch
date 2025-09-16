package exercicio.ex5;

import exercicio.ex5.infra.InMemoryTarefaRepository;
import exercicio.ex5.usecases.ConcluirTarefaUseCase;
import exercicio.ex5.usecases.CriarTarefaUseCase;
import exercicio.ex5.usecases.ListarTarefasPendentesUseCase;

public class App {
    public static void main(String[] args) {
        var repo = new InMemoryTarefaRepository();
        var criar = new CriarTarefaUseCase(repo);
        var listarPendentes = new ListarTarefasPendentesUseCase(repo);
        var concluir = new ConcluirTarefaUseCase(repo);

        criar.executar("Estudar Clean Architecture");
        criar.executar("Escrever testes");

        listarPendentes.executar().forEach(t -> System.out.println("Pendente: "+t.getDescricao()));

        var tarefa = listarPendentes.executar().get(0);
        concluir.executar(tarefa);

        listarPendentes.executar().forEach(t -> System.out.println("Pendente: "+t.getDescricao()));
    }
}
