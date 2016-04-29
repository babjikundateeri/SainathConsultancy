package com.sainath.services.dao.impl;

import com.sainath.services.dao.PersonDAO;
import com.sainath.services.models.sainath.Person;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by babjik on 21/4/16.
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public PersonDAOImpl() {

    }

    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Person> list() {
        List<Person> personList = (List<Person>) sessionFactory.getCurrentSession()
                .createCriteria(Person.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        return personList;
    }

    @Override
    @Transactional
    public Person getById(Integer id) {
        List<Person> personList = (List<Person>)sessionFactory.getCurrentSession()
                .createCriteria(Person.class)
                .add(Restrictions.eq("id", id))
                .list();
        if (personList != null && !personList.isEmpty() && personList.get(0) != null) {
            return (Person) personList.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Person person) {
        sessionFactory.getCurrentSession().saveOrUpdate(person);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Person person = new Person();
        person.setId(id);
        sessionFactory.getCurrentSession().delete(person);
    }
}
