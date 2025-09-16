package exercicio.ex6.usecases;

import exercicio.ex6.entities.Lanche;
import exercicio.ex6.repositories.LancheRepository;

import java.util.List;

public class ListarLanchesUseCase {
    private final LancheRepository repository;

    public ListarLanchesUseCase(LancheRepository repository) { this.repository = repository; }

    public List<Lanche> executar() { return repository.listarTodos(); }
}
