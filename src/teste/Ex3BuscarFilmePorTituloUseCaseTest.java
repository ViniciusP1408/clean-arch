package teste;

import exercicio.ex3.entities.Filme;
import exercicio.ex3.infra.InMemoryFilmeRepository;
import exercicio.ex3.usecases.BuscarFilmePorTituloUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Ex3BuscarFilmePorTituloUseCaseTest {

    @Test
    void deveBuscarFilmePorTitulo() {
        InMemoryFilmeRepository repo = new InMemoryFilmeRepository();
        repo.salvar(new Filme("Matrix", "Ficção", 1999));

        BuscarFilmePorTituloUseCase useCase = new BuscarFilmePorTituloUseCase(repo);
        Filme filme = useCase.executar("matrix");

        assertNotNull(filme);
        assertEquals("Matrix", filme.getTitulo());
        assertEquals("Ficção", filme.getGenero());
        assertEquals(1999, filme.getAno());
    }
}
