package com.lin.person.controller;

import com.lin.person.bean.Person;
import com.lin.person.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PersonController {
    @Resource
    PersonService personService;

    @RequestMapping("/getAllPerson")
    @ResponseBody
    public List<Person> getAllPerson() {
        return personService.getAllPerson();

    }

    @RequestMapping("/addPerson")
    @ResponseBody
    public String addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

}
