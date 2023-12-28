package br.com.fiap;

import br.com.fiap.dao.GameDao;
import br.com.fiap.model.Game;
import br.com.fiap.utils.Conexao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        //pesquisar(em);
        //listarTodosOsGames(em);
        //buscarGamePeloNome(em);
        buscarGamesPorFaixaDeValores(em);

        em.close();

    }

    public static void buscarGamesPorFaixaDeValores(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamesPorFaixaDeValores(150.0, 300.0);

        for (Game game : games) {
            System.out.println(game);
            System.out.println("------------------------");
        }
    }

    public static void buscarGamePeloNome(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamePeloNome("mega man 2".toUpperCase());

        for (Game game : games) {
            System.out.println(game);
            System.out.println("------------------------");
        }
    }


    public static void listarTodosOsGames(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.listarTodosOsGames();

        for (Game game : games) {
            System.out.println(game);
            System.out.println("------------------------");
        }
    }


    public static void pesquisar(EntityManager em) {

        GameDao gameDao = new GameDao(em);
        Game game = new Game();
        game.setId(20L);
        Game gameEncontrado = gameDao.buscarGamePeloId(game);

        if (gameEncontrado != null) {
            System.out.println(gameEncontrado.toString());
        } else {
            System.out.println("Game não encontrado!");
        }

    }

    public static void cadastrar(EntityManager em) {
        Game game1 = new Game();
        game1.setTitulo("Ikari Warriors");
        game1.setCategoria("Arcade");
        game1.setDataLancamento(LocalDate.of(1986, 1, 1));
        game1.setFinalizado(true);
        game1.setProdutora("SNK");
        game1.setValor(256.88);

        GameDao gameDao = new GameDao(em);

        em.getTransaction().begin();
        gameDao.salvar(game1);
        game1.setTitulo("Ikari Warriors SNK");
        em.getTransaction().commit();
    }


}
