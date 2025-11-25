package br.com.tahnous.dao;

import br.com.tahnous.domain.Acessorio;
import br.com.tahnous.domain.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class AcessorioDao implements  IAcessorioDao{
    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return acessorio;
    }

    @Override
    public void excluir(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        acessorio = entityManager.merge(acessorio);
        entityManager.remove(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    public List<Acessorio> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Acessorio> query = builder.createQuery(Acessorio.class);
        Root<Acessorio> root = query.from(Acessorio.class);
        query.select(root);

        TypedQuery<Acessorio> tpQuery =
                entityManager.createQuery(query);
        List<Acessorio> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }

}
