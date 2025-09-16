package exercicio.ex4;

import exercicio.ex4.infra.InMemoryQuartoRepository;
import exercicio.ex4.usecases.CadastrarQuartoUseCase;
import exercicio.ex4.usecases.ListarQuartosUseCase;
import exercicio.ex4.usecases.ReservarQuartoUseCase;

public class App {
    public static void main(String[] args) {
        var repo = new InMemoryQuartoRepository();
        var cadastrar = new CadastrarQuartoUseCase(repo);
        var listar = new ListarQuartosUseCase(repo);
        var reservar = new ReservarQuartoUseCase(repo);

        cadastrar.executar(101, "Single");
        cadastrar.executar(102, "Duplo");

    listar.executar().forEach(q ->
        System.out.println(q.getNumero()+" - "+q.getTipo()+" - "+(q.getStatus()==exercicio.ex4.entities.Quarto.Status.DISPONIVEL?"Disponível":"Ocupado")));

        reservar.executar(101);

    listar.executar().forEach(q ->
        System.out.println(q.getNumero()+" - "+q.getTipo()+" - "+(q.getStatus()==exercicio.ex4.entities.Quarto.Status.DISPONIVEL?"Disponível":"Ocupado")));
    }
}
