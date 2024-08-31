package com.my.springmvc.dao;

import com.my.springmvc.model.Vacation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class JpaVacationDAO implements VacationDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<Vacation> index(UUID id) {
        TypedQuery<Vacation> typedQuery = entityManager.createQuery("SELECT v FROM Vacation v WHERE v.personId =:personId", Vacation.class);
         typedQuery.setParameter("personId", id);
        return typedQuery.getResultList();
    }

    @Override
    public Vacation show(UUID id) {
        TypedQuery<Vacation> typedQuery = entityManager.createQuery("SELECT v FROM Vacation v WHERE v.id =:id", Vacation.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findAny().orElse(null);
    }

    @Transactional
    @Override
    public void save(Vacation vacation) {
        entityManager.persist(vacation);
    }

    @Transactional
    @Override
    public void update(Vacation updatedVacation) {
        entityManager.merge(updatedVacation);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        TypedQuery<Vacation> typedQuery = entityManager.createQuery("SELECT v FROM Vacation v WHERE v.id =:id", Vacation.class);
        typedQuery.setParameter("id", id);
        entityManager.remove(typedQuery.getSingleResult());
    }

    @Transactional
    @Override
    public void deletePersonVacations(UUID personId) {
        TypedQuery<Vacation> typedQuery = entityManager.createQuery("SELECT v FROM Vacation v WHERE v.personId =:personId", Vacation.class);
        typedQuery.setParameter("personId", personId);
        try {
            entityManager.remove(typedQuery.getSingleResult());
        } catch (Exception e) {
            System.out.println("no vacations for deleted person");
        }
    }
}
