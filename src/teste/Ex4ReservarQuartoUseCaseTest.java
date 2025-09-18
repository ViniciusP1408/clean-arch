package teste;

import exercicio.ex4.entities.Quarto;
import exercicio.ex4.infra.InMemoryQuartoRepository;
import exercicio.ex4.usecases.CadastrarQuartoUseCase;
import exercicio.ex4.usecases.ReservarQuartoUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Ex4ReservarQuartoUseCaseTest {

    @Test
    void deveReservarQuartoDisponivel() {
        InMemoryQuartoRepository repo = new InMemoryQuartoRepository();
        new CadastrarQuartoUseCase(repo).executar(101, "Solteiro");

        new ReservarQuartoUseCase(repo).executar(101);

        Quarto q = repo.buscarPorNumero(101);
        assertEquals(Quarto.Status.OCUPADO, q.getStatus());
    }
}
