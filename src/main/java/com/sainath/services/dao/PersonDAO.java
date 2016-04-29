package com.sainath.services.dao;

import com.sainath.services.models.sainath.Person;

import java.util.List;

/**
 * Created by babjik on 21/4/16.
 */
public interface PersonDAO {

    public List<Person> list();

    public Person getById(final Integer id);

    public void saveOrUpdate(final Person person);

    public void delete(final Integer id);
}
