package com.my.springmvc.dao;

import com.my.springmvc.model.Vacation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class JpaVacationDAO implements VacationDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<Vacation> index(UUID personId) {
        TypedQuery<Vacation> typedQuery = entityManager.createQuery("SELECT * FROM Vacation v WHERE person_id =:personId", Vacation.class);
         typedQuery.setParameter("personId", personId);
        return typedQuery.getResultList();
    }

    @Override
    public Vacation show(UUID id) {
        TypedQuery<Vacation> typedQuery = entityManager.createQuery("SELECT v FROM Vacation v WHERE id =:id", Vacation.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void save(Vacation vacation) {

    }

    @Override
    public void update(UUID id, Vacation updatedVacation) {

    }

    @Override
    public void delete(UUID id) {

    }
}
