package com.lin.person.service.Impl;

import com.lin.person.bean.Person;
import com.lin.person.mapper.PersonMapper;
import com.lin.person.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonImpl implements PersonService {

    @Resource
    PersonMapper personMapper;

    public List<Person> getAllPerson() {
        return personMapper.selectAllPerson();
    }

    public String addPerson(Person person) {
        try {
            personMapper.insertPerson(person);
            return "success";
        }
        catch (Exception e) {
            return "error:\n" + e;
        }
    }
}
