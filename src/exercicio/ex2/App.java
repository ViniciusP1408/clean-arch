package exercicio.ex2;

import exercicio.ex2.entities.Funcionario;
import exercicio.ex2.infra.InMemoryFuncionarioRepository;
import exercicio.ex2.usecases.ListarFuncionariosUseCase;

public class App {
    public static void main(String[] args) {
        var repo = new InMemoryFuncionarioRepository();
        repo.salvar(new Funcionario("Clara", "Analista", 7000));
        repo.salvar(new Funcionario("Diego", "Desenvolvedor", 9000));

        var listar = new ListarFuncionariosUseCase(repo);
        listar.executar().forEach(dto ->
                System.out.println(dto.nome+" - "+dto.cargo+" - R$ "+dto.salario));
    }
}
