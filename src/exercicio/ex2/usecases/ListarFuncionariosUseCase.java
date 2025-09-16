package exercicio.ex2.usecases;

import exercicio.ex2.repositories.FuncionarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ListarFuncionariosUseCase {
    public static class FuncionarioDTO {
        public final String nome;
        public final String cargo;
        public final double salario;
        public FuncionarioDTO(String nome, String cargo, double salario) {
            this.nome = nome; this.cargo = cargo; this.salario = salario;
        }
    }

    private final FuncionarioRepository repository;

    public ListarFuncionariosUseCase(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<FuncionarioDTO> executar() {
        return repository.listarTodos().stream()
                .map(f -> new FuncionarioDTO(f.getNome(), f.getCargo(), f.getSalario()))
                .collect(Collectors.toList());
    }
}
