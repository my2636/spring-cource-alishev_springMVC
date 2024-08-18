package com.my.springmvc.dao;

import com.my.springmvc.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class JpaPersonDAO implements PersonDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> index() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Override
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    public Person show(UUID id) {
        TypedQuery<Person> typedQuery = entityManager.createQuery("SELECT p FROM Person p where p.id = :id", Person.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findAny().orElse(null);

    }

    @Override
    public void update(UUID id, Person updatePerson) {

    }

    @Override
    public void delete(UUID id) {

    }
}
