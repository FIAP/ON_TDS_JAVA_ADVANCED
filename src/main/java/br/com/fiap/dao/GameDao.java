package br.com.fiap.dao;

import br.com.fiap.model.Game;
import jakarta.persistence.EntityManager;

public class GameDao {

    private EntityManager em;

    public GameDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Game game) {
        em.persist(game);
    }

    public void atualizar(Game game) {
        em.merge(game);
    }

    public void remover(Game game) {
        Game gameExcluir = em.find(Game.class, game.getId());
        em.remove(gameExcluir);
    }

}
