package com.example.ProjectBoot.dao;

import com.example.ProjectBoot.models.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonDaoImpl implements PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> index() {
        return entityManager.createQuery("from Person", Person.class).getResultList();
    }

    public Person show(int id) {
        return entityManager.find(Person.class, id);
    }

    public void save(Person person) {
        entityManager.merge(person);
    }

    public void update(int id, Person updatedPerson) {
        entityManager.merge(updatedPerson);
    }

    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(Person.class, id));
    }
}
