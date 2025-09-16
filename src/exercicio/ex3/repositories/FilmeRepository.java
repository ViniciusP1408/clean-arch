package exercicio.ex3.repositories;

import exercicio.ex3.entities.Filme;

import java.util.List;

public interface FilmeRepository {
    void salvar(Filme filme);
    Filme buscarPorTitulo(String titulo);
    List<Filme> listarTodos();
}
