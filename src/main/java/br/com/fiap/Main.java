package br.com.fiap;

import br.com.fiap.dao.GameDao;
import br.com.fiap.model.Game;
import br.com.fiap.utils.Conexao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Game game1 = new Game();
        game1.setId(4L);
        game1.setTitulo("Batletoads");
        game1.setCategoria("Luta");
        //game1.setDataLancamento(LocalDate.of(1992, 8, 1));
        game1.setDataLancamento(LocalDate.of(1992, 6, 1));
        game1.setFinalizado(true);
        //game1.setProdutora("Tradewest");
        game1.setProdutora("Tradewest, Rare");
        game1.setValor(99.89);

        EntityManager em = Conexao.getEntityManager();
        GameDao gameDao = new GameDao(em);

        em.getTransaction().begin();
        //gameDao.salvar(game1);
        //gameDao.atualizar(game1);
        gameDao.remover(game1);
        em.getTransaction().commit();
        em.close();

    }

}
