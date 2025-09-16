package exercicio.ex6.infra;

import exercicio.ex6.entities.Pedido;
import exercicio.ex6.repositories.PedidoRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPedidoRepository implements PedidoRepository {
    private final List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void salvar(Pedido pedido) { pedidos.add(pedido); }

    @Override
    public List<Pedido> listarTodos() { return pedidos; }
}
