package exercicio.ex2.infra;

import exercicio.ex2.entities.Funcionario;
import exercicio.ex2.repositories.FuncionarioRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFuncionarioRepository implements FuncionarioRepository {
    private final List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void salvar(Funcionario f) {
        funcionarios.add(f);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarios;
    }
}
