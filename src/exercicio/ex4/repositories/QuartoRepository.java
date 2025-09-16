package exercicio.ex4.repositories;

import exercicio.ex4.entities.Quarto;

import java.util.List;

public interface QuartoRepository {
    void salvar(Quarto quarto);
    Quarto buscarPorNumero(int numero);
    List<Quarto> listarTodos();
}
