package exercicio.ex4.infra;

import exercicio.ex4.entities.Quarto;
import exercicio.ex4.repositories.QuartoRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryQuartoRepository implements QuartoRepository {
    private final List<Quarto> quartos = new ArrayList<>();

    @Override
    public void salvar(Quarto quarto) { quartos.add(quarto); }

    @Override
    public Quarto buscarPorNumero(int numero) {
        return quartos.stream()
                .filter(q -> q.getNumero() == numero)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));
    }

    @Override
    public List<Quarto> listarTodos() { return quartos; }
}
