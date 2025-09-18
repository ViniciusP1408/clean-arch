package teste;

import exercicio.ex6.entities.Lanche;
import exercicio.ex6.entities.Pedido;
import exercicio.ex6.infra.InMemoryLancheRepository;
import exercicio.ex6.infra.InMemoryPedidoRepository;
import exercicio.ex6.usecases.CriarPedidoUseCase;
import exercicio.ex6.usecases.FinalizarPedidoUseCase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Ex6PedidosTest {

    @Test
    void deveCriarPedidoComTotalCorreto() {
        InMemoryLancheRepository lancheRepo = new InMemoryLancheRepository();
        InMemoryPedidoRepository pedidoRepo = new InMemoryPedidoRepository();
        lancheRepo.salvar(new Lanche("X-Salada", 20.0, true));
        lancheRepo.salvar(new Lanche("Suco", 8.5, true));

        CriarPedidoUseCase useCase = new CriarPedidoUseCase(pedidoRepo, lancheRepo);
        Pedido pedido = useCase.executar(Arrays.asList("X-Salada", "Suco"));

        assertEquals(2, pedido.getLanches().size());
        assertEquals(28.5, pedido.getValorTotal(), 0.0001);

        new FinalizarPedidoUseCase().executar(pedido);
        assertEquals(Pedido.Status.FINALIZADO, pedido.getStatus());
    }

    @Test
    void naoDeveAdicionarLancheIndisponivel() {
        InMemoryLancheRepository lancheRepo = new InMemoryLancheRepository();
        InMemoryPedidoRepository pedidoRepo = new InMemoryPedidoRepository();
        lancheRepo.salvar(new Lanche("Batata", 10.0, false));

        CriarPedidoUseCase useCase = new CriarPedidoUseCase(pedidoRepo, lancheRepo);

        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> useCase.executar(Arrays.asList("Batata")));
        assertEquals("Lanche indisponível", ex.getMessage());
    }
}
