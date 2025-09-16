package exercicio.ex6.infra;

import exercicio.ex6.entities.Lanche;
import exercicio.ex6.repositories.LancheRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLancheRepository implements LancheRepository {
    private final List<Lanche> lanches = new ArrayList<>();

    @Override
    public void salvar(Lanche lanche) { lanches.add(lanche); }

    @Override
    public List<Lanche> listarTodos() { return lanches; }

    @Override
    public Lanche buscarPorNome(String nome) {
        return lanches.stream()
                .filter(l -> l.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Lanche não encontrado"));
    }
}
