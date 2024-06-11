package com.example.ProjectBoot.service;


import com.example.ProjectBoot.dao.PersonDao;
import com.example.ProjectBoot.models.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> index() {
        return personDao.index();
    }

    @Transactional(readOnly = true)
    @Override
    public Person show(int id) {
        return personDao.show(id);
    }

    @Transactional
    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Transactional
    @Override
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        personDao.update(id, updatedPerson);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        personDao.deleteUser(id);
    }
}
