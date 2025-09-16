package exercicio.ex1.usecases;

import exercicio.ex1.entities.Aluno;
import exercicio.ex1.repositories.AlunoRepository;

public class CadastrarAlunoUseCase {
    private final AlunoRepository repository;

    public CadastrarAlunoUseCase(AlunoRepository repository) {
        this.repository = repository;
    }

    public void executar(String nome, String matricula, String curso) {
        repository.salvar(new Aluno(nome, matricula, curso));
    }
}
