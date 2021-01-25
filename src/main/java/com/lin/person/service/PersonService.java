package com.lin.person.service;

import com.lin.person.bean.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    List<Person> getAllPerson();
    String addPerson(Person person);
}
