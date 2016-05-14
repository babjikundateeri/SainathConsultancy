package com.sainath.services.contorller.web;

import com.sainath.services.dao.PersonDAO;
import com.sainath.services.formbeans.personform.PersonFormBean;
import com.sainath.services.models.sainath.Person;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by babjik on 21/4/16.
 */
@Controller
public class SainathConsultancyController {
    private static final Logger LOGGER = Logger.getLogger(SainathConsultancyController.class);

    @Autowired
    private PersonDAO personDAO;

    @RequestMapping(value = "/persons")
    public ModelAndView getPersonsList() {
        List<Person> personList = personDAO.list();
        ModelAndView modelAndView = new ModelAndView("persons");
        modelAndView.addObject("personsList", personList);
        System.out.println("list " + personList);
        System.out.println(" email "+ personList.get(0).getEmailInfos());
        System.out.println(" mobile "+ personList.get(0).getMobileInfos());
        LOGGER.info("personsList " + personList);
        return modelAndView;
    }

    @RequestMapping(value = "/persons/new", method = RequestMethod.GET)
    public ModelAndView newPersonForm() {
        ModelAndView modelAndView = new ModelAndView("newpersion");
        return modelAndView;
    }

    @RequestMapping(value = "/persons/new", method = RequestMethod.POST)
    public ModelAndView saveOrUpdatePerson(@ModelAttribute PersonFormBean personFormBean) {
        ModelAndView modelAndView = new ModelAndView("newpersion");
        LOGGER.info("Data from form data " + personFormBean);
        return modelAndView;
    }
}
