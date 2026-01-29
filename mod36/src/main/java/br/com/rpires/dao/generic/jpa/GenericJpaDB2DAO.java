package br.com.rpires.dao.generic.jpa;

import br.com.rpires.domain.jpa.Persistente;

import java.io.Serializable;

public class GenericJpaDB2DAO <T extends Persistente, E extends Serializable>
        extends GenericJpaDAO<T,E> {

    public GenericJpaDB2DAO(Class<T> persistenteClass) {
        super(persistenteClass, "Postgre2");
    }

}
