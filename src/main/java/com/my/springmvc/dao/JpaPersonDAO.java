package com.my.springmvc.dao;

import com.my.springmvc.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class JpaPersonDAO implements PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Person> index() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Override
    public Person show(UUID id) {
        TypedQuery<Person> typedQuery = entityManager.createQuery("SELECT p FROM Person p where p.id =:id", Person.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findAny().orElse(null);

    }

    @Transactional
    @Override
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    @Override
    public void update(Person updatePerson) {
        entityManager.merge(updatePerson);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        TypedQuery<Person> typedQuery = entityManager.createQuery("SELECT p FROM Person p WHERE p.id =:id", Person.class);
        typedQuery.setParameter("id", id);
        entityManager.remove(typedQuery.getSingleResult());
    }
}
