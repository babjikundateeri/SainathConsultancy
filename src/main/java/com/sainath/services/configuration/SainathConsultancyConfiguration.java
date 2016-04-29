package com.sainath.services.configuration;

import com.sainath.services.dao.PersonDAO;
import com.sainath.services.dao.impl.PersonDAOImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by babjik on 19/4/16.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sainath.services")
@EnableTransactionManagement
public class SainathConsultancyConfiguration {

    // view resolver
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsps/");
        internalResourceViewResolver.setSuffix(".jsp");
        return  internalResourceViewResolver;
    }

    // data source
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
//        JndiObjectFactoryBean jndi  = new JndiObjectFactoryBean();
//        jndi.setJndiName("java:mysql/sainathDS");
//        return (DataSource) jndi.getObject();
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        dataSourceLookup.setResourceRef(true);
        return dataSourceLookup.getDataSource("java:jboss/datasources/sainathDS");
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);

        // need to add all annoted classes here
        // sessionFactoryBuilder.addAnnotatedClasses(Person.class);
        sessionFactoryBuilder.scanPackages("com.sainath.services.models");

        // configuring hibernate settings
        sessionFactoryBuilder.addProperties(getHibernateProperties());

        return sessionFactoryBuilder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return  properties;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return  transactionManager;
    }


    // configuring DAO beans
    @Autowired
    @Bean(name = "personDAO")
    public PersonDAO getPersonDAO(SessionFactory sessionFactory) {
        return new PersonDAOImpl(sessionFactory);
    }
}
