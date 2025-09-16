package exercicio.ex6;

import exercicio.ex6.infra.InMemoryLancheRepository;
import exercicio.ex6.infra.InMemoryPedidoRepository;
import exercicio.ex6.usecases.CadastrarLancheUseCase;
import exercicio.ex6.usecases.CriarPedidoUseCase;
import exercicio.ex6.usecases.FinalizarPedidoUseCase;
import exercicio.ex6.usecases.ListarLanchesUseCase;

import java.util.List;

public class App {
    public static void main(String[] args) {
        var lancheRepo = new InMemoryLancheRepository();
        var pedidoRepo = new InMemoryPedidoRepository();

        var cadastrarLanche = new CadastrarLancheUseCase(lancheRepo);
        var listarLanches = new ListarLanchesUseCase(lancheRepo);
        var criarPedido = new CriarPedidoUseCase(pedidoRepo, lancheRepo);
        var finalizarPedido = new FinalizarPedidoUseCase();

        cadastrarLanche.executar("X-Burger", 20.0, true);
        cadastrarLanche.executar("X-Salada", 22.0, true);
        cadastrarLanche.executar("Milkshake", 15.0, false);

        listarLanches.executar().forEach(l -> System.out.println(l.getNome()+" - R$ "+l.getPreco()+" - "+(l.isDisponivel()?"OK":"Indisp.")));

        var pedido = criarPedido.executar(List.of("X-Burger", "X-Salada"));
        System.out.println("Total pedido: R$ "+pedido.getValorTotal());

        finalizarPedido.executar(pedido);

        try {
            criarPedido.executar(List.of("Milkshake"));
        } catch (Exception e) {
            System.out.println("Erro esperado ao incluir indisponível: "+e.getMessage());
        }
    }
}
