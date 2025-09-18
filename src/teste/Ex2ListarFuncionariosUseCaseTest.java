package teste;

import exercicio.ex2.entities.Funcionario;
import exercicio.ex2.infra.InMemoryFuncionarioRepository;
import exercicio.ex2.usecases.ListarFuncionariosUseCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Ex2ListarFuncionariosUseCaseTest {

    @Test
    void deveListarFuncionariosComoDTO() {
        InMemoryFuncionarioRepository repo = new InMemoryFuncionarioRepository();
        repo.salvar(new Funcionario("Ana", "Dev", 5000));
        repo.salvar(new Funcionario("Bruno", "QA", 4000));

        ListarFuncionariosUseCase useCase = new ListarFuncionariosUseCase(repo);
        List<ListarFuncionariosUseCase.FuncionarioDTO> dtos = useCase.executar();

        assertEquals(2, dtos.size());
        assertEquals("Ana", dtos.get(0).nome);
        assertEquals("Dev", dtos.get(0).cargo);
    assertEquals(5000.0, dtos.get(0).salario, 0.0001);
    }
}
