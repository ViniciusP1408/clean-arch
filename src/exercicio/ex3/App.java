package exercicio.ex3;

import exercicio.ex3.entities.Filme;
import exercicio.ex3.infra.InMemoryFilmeRepository;
import exercicio.ex3.usecases.BuscarFilmePorTituloUseCase;

public class App {
    public static void main(String[] args) {
        var repo = new InMemoryFilmeRepository();
        repo.salvar(new Filme("Matrix", "Ficção", 1999));
        repo.salvar(new Filme("Interestelar", "Ficção", 2014));

        var buscar = new BuscarFilmePorTituloUseCase(repo);
        System.out.println(buscar.executar("Matrix").getTitulo());

        try {
            buscar.executar("Inexistente");
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: "+e.getMessage());
        }
    }
}
