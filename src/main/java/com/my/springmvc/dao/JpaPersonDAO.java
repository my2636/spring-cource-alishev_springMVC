package com.my.springmvc.dao;

import com.my.springmvc.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class JpaPersonDAO implements PersonDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
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
        TypedQuery<Person> typedQuery = entityManager.createQuery("SELECT p FROM Person p where p.id =:id", Person.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findAny().orElse(null);

    }

    @Override
    public void update(UUID id, Person updatePerson) {
        TypedQuery<Person> typedQuery = entityManager.createQuery("UPDATE Person p SET p.first_name =:firstname, " +
                "p.last_name =:lastname, p.nickname =:nickname, p.email =:email, p.birthday =:birthday, p.city =:city WHERE p.id =:id", Person.class);
        typedQuery.setParameter("id", id);
        typedQuery.setParameter("firstname", updatePerson.getFirstName());
        typedQuery.setParameter("lastname", updatePerson.getLastName());
        typedQuery.setParameter("nickname", updatePerson.getNickname());
        typedQuery.setParameter("email", updatePerson.getEmail());
        typedQuery.setParameter("birthday", updatePerson.getBirthday());
        typedQuery.setParameter("city", updatePerson.getCity());
    }

    @Override
    public void delete(UUID id) {
        TypedQuery<Person> typedQuery = entityManager.createQuery("DELETE FROM Person p WHERE p.id =:id", Person.class);
    }
}
