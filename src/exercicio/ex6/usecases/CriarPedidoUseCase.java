package exercicio.ex6.usecases;

import exercicio.ex6.entities.Lanche;
import exercicio.ex6.entities.Pedido;
import exercicio.ex6.repositories.LancheRepository;
import exercicio.ex6.repositories.PedidoRepository;

import java.util.List;

public class CriarPedidoUseCase {
    private final PedidoRepository pedidoRepository;
    private final LancheRepository lancheRepository;

    public CriarPedidoUseCase(PedidoRepository pedidoRepository, LancheRepository lancheRepository) {
        this.pedidoRepository = pedidoRepository;
        this.lancheRepository = lancheRepository;
    }

    public Pedido executar(List<String> nomesLanches) {
        Pedido pedido = new Pedido();
        for (String nome : nomesLanches) {
            Lanche lanche = lancheRepository.buscarPorNome(nome);
            pedido.adicionarLanche(lanche);
        }
        pedidoRepository.salvar(pedido);
        return pedido;
    }
}
