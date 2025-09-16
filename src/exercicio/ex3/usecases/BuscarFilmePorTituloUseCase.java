package exercicio.ex3.usecases;

import exercicio.ex3.entities.Filme;
import exercicio.ex3.repositories.FilmeRepository;

public class BuscarFilmePorTituloUseCase {
    private final FilmeRepository repository;

    public BuscarFilmePorTituloUseCase(FilmeRepository repository) {
        this.repository = repository;
    }

    public Filme executar(String titulo) {
        return repository.buscarPorTitulo(titulo);
    }
}
