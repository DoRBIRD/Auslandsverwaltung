package de.hsb.auslandsverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ModelViewController {

	@Autowired private AuslandsverwaltungDAO auslandsverwaltungDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<student> studenten;
		studenten = auslandsverwaltungDAO.findAll();
		model.addAttribute("studenten", studenten);

		return "index";
	}
}
