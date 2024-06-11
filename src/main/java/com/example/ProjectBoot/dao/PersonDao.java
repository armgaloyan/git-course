package com.example.ProjectBoot.dao;


import com.example.ProjectBoot.models.Person;

import java.util.List;

public interface PersonDao {
    List<Person> index();
    Person show(int id);
    void save(Person person);
    void update(int id, Person updatedPerson);
    void deleteUser(int id);
}
