package com.spring.test.person;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class HomeController {
	@Autowired
    private PersonDao personDao;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
	    List<PersonDetail> listPerson = personDao.listPer();
	    model.addObject("listPerson", listPerson);
	    model.setViewName("home");
	    return model;
	}
	
	@RequestMapping(value = "/getPersonById", method = RequestMethod.GET)
	public ModelAndView editPerson(HttpServletRequest request) {
	    int personId = Integer.parseInt(request.getParameter("id"));
	    PersonDetail person = personDao.getPer(personId);
	    ModelAndView model = new ModelAndView("home");
	    model.addObject("personInfo", person);
	    
	    List<PersonDetail> listPerson = personDao.listPer();
		model.addObject("listPerson", listPerson);
		model.setViewName("home");
	 
	    return model;
	}
	
	@RequestMapping(value = "/updatePeronById", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int perId = Integer.parseInt(request.getParameter("id"));
	    System.out.println(perId);
	    PersonDetail person = personDao.getPer(perId);
	    ModelAndView model = new ModelAndView("personUpdate");
	    model.addObject("person", person);
	    model.setViewName("personUpdate");
	    return model;
	}
	
	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    int perId = Integer.parseInt(request.getParameter("id"));
	    personDao.deletePer(perId);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public ModelAndView savePerson(@ModelAttribute PersonDetail person) {
		personDao.updatePer(person);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/newPerson")
	public ModelAndView newPerson(ModelAndView model) {
	    PersonDetail newPer = new PersonDetail();
	    model.addObject("person", newPer);
	    model.setViewName("newPerson");
	    return model;
	}
	
	@RequestMapping(value = "/saveNewPerson", method = RequestMethod.POST)
	public ModelAndView saveNewPerson(@ModelAttribute PersonDetail person) {
	    String result = personDao.newPer(person);
	    if(result == "Success"){
	    	return new ModelAndView("redirect:/");
	    }else{
	    ModelAndView model = new ModelAndView("newPerson");
	    PersonDetail newPer = new PersonDetail();
	    model.addObject("person", newPer);
	    model.addObject("result", result);
	    model.setViewName("newPerson");
	    return model;
	    }
	}
}
