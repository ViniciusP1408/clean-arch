package exercicio.ex6.usecases;

import exercicio.ex6.entities.Pedido;

public class FinalizarPedidoUseCase {
    public void executar(Pedido pedido) {
        pedido.finalizar();
    }
}
