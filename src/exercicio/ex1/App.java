package exercicio.ex1;

import exercicio.ex1.infra.InMemoryAlunoRepository;
import exercicio.ex1.usecases.CadastrarAlunoUseCase;

public class App {
    public static void main(String[] args) {
        var repo = new InMemoryAlunoRepository();
        var cadastrar = new CadastrarAlunoUseCase(repo);

        cadastrar.executar("Ana", "2025001", "Engenharia");
        cadastrar.executar("Bruno", "2025002", "Computação");

        repo.listarTodos().forEach(a ->
                System.out.println(a.getMatricula()+" - "+a.getNome()+" ("+a.getCurso()+")"));
    }
}
