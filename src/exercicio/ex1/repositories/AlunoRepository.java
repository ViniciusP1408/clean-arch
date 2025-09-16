package exercicio.ex1.repositories;

import exercicio.ex1.entities.Aluno;

import java.util.List;

public interface AlunoRepository {
    void salvar(Aluno aluno);
    Aluno buscarPorMatricula(String matricula);
    List<Aluno> listarTodos();
}
