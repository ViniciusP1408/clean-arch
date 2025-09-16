package exercicio.ex3.infra;

import exercicio.ex3.entities.Filme;
import exercicio.ex3.repositories.FilmeRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFilmeRepository implements FilmeRepository {
    private final List<Filme> filmes = new ArrayList<>();

    @Override
    public void salvar(Filme filme) {
        filmes.add(filme);
    }

    @Override
    public Filme buscarPorTitulo(String titulo) {
        return filmes.stream()
                .filter(f -> f.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    @Override
    public List<Filme> listarTodos() {
        return filmes;
    }
}
