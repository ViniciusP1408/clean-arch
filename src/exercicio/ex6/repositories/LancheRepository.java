package exercicio.ex6.repositories;

import exercicio.ex6.entities.Lanche;

import java.util.List;

public interface LancheRepository {
    void salvar(Lanche lanche);
    List<Lanche> listarTodos();
    Lanche buscarPorNome(String nome);
}
