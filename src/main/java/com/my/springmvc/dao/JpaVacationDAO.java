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

    @Transactional
    @Override
    public void save(Vacation vacation) {
        entityManager.persist(vacation);
    }

    @Transactional
    @Override
    public void update(UUID id, Vacation updatedVacation) {
        TypedQuery<Vacation> typedQuery = entityManager.createQuery("UPDATE Vacation v SET v.person_id =:personId, " +
                "v.vacation_name =:vacationName, v.date_start =:dateStart, v.date_finish =:dateFinish WHERE v.id =:id", Vacation.class);
        typedQuery.setParameter("id", id);
        typedQuery.setParameter("personId", updatedVacation.getPersonId());
        typedQuery.setParameter("vacationName", updatedVacation.getVacationName());
        typedQuery.setParameter("dateStart", updatedVacation.getDateStart());
        typedQuery.setParameter("dateFinish", updatedVacation.getDateFinish());
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        TypedQuery<Vacation> typedQuery = entityManager.createQuery("DELETE FROM Vacation v WHERE v.id =:id", Vacation.class);
        typedQuery.setParameter("id", id);
    }

    @Transactional
    public void deletePersonVacations(UUID personId) {
        TypedQuery<Vacation> typedQuery = entityManager.createQuery("DELETE FROM Vacation v WHERE v.person_id =:personId", Vacation.class);
        typedQuery.setParameter("personId", personId);
    }
}
