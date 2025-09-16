package exercicio.ex4.usecases;

import exercicio.ex4.entities.Quarto;
import exercicio.ex4.repositories.QuartoRepository;

public class ReservarQuartoUseCase {
    private final QuartoRepository repository;

    public ReservarQuartoUseCase(QuartoRepository repository) { this.repository = repository; }

    public void executar(int numero) {
        Quarto quarto = repository.buscarPorNumero(numero);
        quarto.reservar();
    }
}
