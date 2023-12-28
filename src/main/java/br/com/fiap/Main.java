package br.com.fiap;

import br.com.fiap.dao.GameDao;
import br.com.fiap.model.Game;
import br.com.fiap.utils.Conexao;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Game game1 = new Game();
        game1.setTitulo("Ikari Warriors");
        game1.setCategoria("Arcade");
        game1.setDataLancamento(LocalDate.of(1986, 1, 1));
        game1.setFinalizado(true);
        game1.setProdutora("SNK");
        game1.setValor(256.88);

        EntityManager em = Conexao.getEntityManager();
        GameDao gameDao = new GameDao(em);

        em.getTransaction().begin();
        gameDao.salvar(game1);
        game1.setTitulo("Ikari Warriors SNK");
        em.getTransaction().commit();

        em.close();



    }

}
