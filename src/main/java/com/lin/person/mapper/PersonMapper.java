package com.lin.person.mapper;

import com.lin.person.bean.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    List<Person> selectAllPerson();
    void insertPerson(@Param("person")Person person);
}
