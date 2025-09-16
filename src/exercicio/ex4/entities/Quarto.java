package exercicio.ex4.entities;

public class Quarto {
    public enum Status { DISPONIVEL, OCUPADO }

    private final int numero;
    private final String tipo;
    private Status status;

    public Quarto(int numero, String tipo) {
        if (numero <= 0) throw new IllegalArgumentException("Número inválido");
        if (tipo == null || tipo.isBlank()) throw new IllegalArgumentException("Tipo inválido");
        this.numero = numero;
        this.tipo = tipo;
        this.status = Status.DISPONIVEL;
    }

    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public Status getStatus() { return status; }

    public void reservar() {
        if (status == Status.OCUPADO) throw new IllegalStateException("Quarto já ocupado");
        status = Status.OCUPADO;
    }
}
