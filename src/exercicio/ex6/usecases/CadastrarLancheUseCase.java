package exercicio.ex6.usecases;

import exercicio.ex6.entities.Lanche;
import exercicio.ex6.repositories.LancheRepository;

public class CadastrarLancheUseCase {
    private final LancheRepository repository;

    public CadastrarLancheUseCase(LancheRepository repository) { this.repository = repository; }

    public void executar(String nome, double preco, boolean disponivel) {
        repository.salvar(new Lanche(nome, preco, disponivel));
    }
}
