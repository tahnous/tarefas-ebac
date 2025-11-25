package br.com.tahnous.dao;

import br.com.tahnous.domain.Carro;
import br.com.tahnous.domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CarroDao implements  ICarroDao{

    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }

    @Override
    public void excluir(Carro carro) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        carro = entityManager.merge(carro);
        entityManager.remove(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public List<Carro> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
        Root<Carro> root = query.from(Carro.class);
        query.select(root);

        TypedQuery<Carro> tpQuery =
                entityManager.createQuery(query);
        List<Carro> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
}
