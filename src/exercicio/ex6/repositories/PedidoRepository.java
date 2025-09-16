package exercicio.ex6.repositories;

import exercicio.ex6.entities.Pedido;

import java.util.List;

public interface PedidoRepository {
    void salvar(Pedido pedido);
    List<Pedido> listarTodos();
}
