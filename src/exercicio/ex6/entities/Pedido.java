package exercicio.ex6.entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public enum Status { ABERTO, FINALIZADO }

    private final List<Lanche> lanches = new ArrayList<>();
    private double valorTotal = 0.0;
    private Status status = Status.ABERTO;

    public List<Lanche> getLanches() { return lanches; }
    public double getValorTotal() { return valorTotal; }
    public Status getStatus() { return status; }

    public void adicionarLanche(Lanche lanche) {
        if (status == Status.FINALIZADO) throw new IllegalStateException("Pedido finalizado não pode ser alterado");
        if (!lanche.isDisponivel()) throw new IllegalStateException("Lanche indisponível");
        lanches.add(lanche);
        valorTotal += lanche.getPreco();
    }

    public void finalizar() {
        if (status == Status.FINALIZADO) throw new IllegalStateException("Pedido já finalizado");
        status = Status.FINALIZADO;
    }
}
