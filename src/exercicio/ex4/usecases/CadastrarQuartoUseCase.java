package exercicio.ex4.usecases;

import exercicio.ex4.entities.Quarto;
import exercicio.ex4.repositories.QuartoRepository;

public class CadastrarQuartoUseCase {
    private final QuartoRepository repository;

    public CadastrarQuartoUseCase(QuartoRepository repository) { this.repository = repository; }

    public void executar(int numero, String tipo) {
        repository.salvar(new Quarto(numero, tipo));
    }
}
