package exercicio.ex4.usecases;

import exercicio.ex4.entities.Quarto;
import exercicio.ex4.repositories.QuartoRepository;

import java.util.List;

public class ListarQuartosUseCase {
    private final QuartoRepository repository;

    public ListarQuartosUseCase(QuartoRepository repository) { this.repository = repository; }

    public List<Quarto> executar() { return repository.listarTodos(); }
}
