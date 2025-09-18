package teste;

import exercicio.ex1.entities.Aluno;
import exercicio.ex1.infra.InMemoryAlunoRepository;
import exercicio.ex1.usecases.CadastrarAlunoUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Ex1CadastrarAlunoUseCaseTest {

    @Test
    void deveCadastrarAlunoComSucesso() {
        InMemoryAlunoRepository repo = new InMemoryAlunoRepository();
        CadastrarAlunoUseCase useCase = new CadastrarAlunoUseCase(repo);

        useCase.executar("João Silva", "MAT123", "ADS");

        Aluno aluno = repo.buscarPorMatricula("MAT123");
        assertNotNull(aluno);
        assertEquals("João Silva", aluno.getNome());
        assertEquals("MAT123", aluno.getMatricula());
        assertEquals("ADS", aluno.getCurso());
    }
}
