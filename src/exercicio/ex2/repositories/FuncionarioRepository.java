package exercicio.ex2.repositories;

import exercicio.ex2.entities.Funcionario;

import java.util.List;

public interface FuncionarioRepository {
    void salvar(Funcionario f);
    List<Funcionario> listarTodos();
}
