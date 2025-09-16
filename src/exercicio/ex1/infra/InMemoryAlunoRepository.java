package exercicio.ex1.infra;

import exercicio.ex1.entities.Aluno;
import exercicio.ex1.repositories.AlunoRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAlunoRepository implements AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();

    @Override
    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public Aluno buscarPorMatricula(String matricula) {
        return alunos.stream()
                .filter(a -> a.getMatricula().equals(matricula))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @Override
    public List<Aluno> listarTodos() {
        return alunos;
    }
}
