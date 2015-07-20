package de.hsb.auslandsverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
@Controller
@RequestMapping("/")
public class ModelViewController {

	@Autowired private AuslandsverwaltungDAO auslandsverwaltungDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<student> studenten;
		studenten = auslandsverwaltungDAO.findAll();
		model.addAttribute("studenten", studenten);

		return "home";
	}
}
*/



@Controller
@RequestMapping("/")
public class ModelViewController {

	@Autowired private AuslandsverwaltungDAO auslandsverwaltungDAO;
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("index");
		return model;

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		List<student> studenten;
		studenten = auslandsverwaltungDAO.findAll();

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.addObject("studenten", studenten);
		model.setViewName("home");

		model.addObject(AuslandsverwaltungDAO.class);



		return model;

	}

}