package teste;

import exercicio.ex5.entities.Tarefa;
import exercicio.ex5.infra.InMemoryTarefaRepository;
import exercicio.ex5.usecases.ConcluirTarefaUseCase;
import exercicio.ex5.usecases.CriarTarefaUseCase;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class Ex5TarefasTest {

    @Test
    void naoDevePermitirCriarTarefaConcluida() {
        InMemoryTarefaRepository repo = new InMemoryTarefaRepository();
        new CriarTarefaUseCase(repo).executar("Estudar Clean Architecture");

        // Nenhuma tarefa deve ser criada já concluída
        long concluidas = repo.listarTodas().stream()
                .filter(t -> t.getStatus() == Tarefa.Status.CONCLUIDA)
                .count();
        assertEquals(0, concluidas);
    }

    @Test
    void naoDevePermitirConcluirDuasVezes() {
        Tarefa t = new Tarefa("Fazer exercícios");
        ConcluirTarefaUseCase useCase = new ConcluirTarefaUseCase(null);
        useCase.executar(t);

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> useCase.executar(t));
        assertEquals("Tarefa já concluída", ex.getMessage());
    }
}
