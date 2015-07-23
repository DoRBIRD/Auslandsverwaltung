package auslandsverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class MVC {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView defaultCall( ModelAndView model ) {
        //Call the default method directly, or use the 'forward' String. Example:
        return index();
    }

    @Autowired private DAO dao;
    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        List<StudentEntity> studenten = dao.findAllStudents();
        model.addObject("studenten", studenten);
        model.addObject("test","test");
        model.setViewName("index");
        model.addObject(DAO.class);
        return model;
    }

    @RequestMapping(value = {"/chooseStudent"}, method = RequestMethod.GET)
    public ModelAndView chooseStudent() {
        ModelAndView model = new ModelAndView();
        List<StudentEntity> studenten = dao.findAllStudents();
        model.addObject("studenten", studenten);
        model.addObject("test","test");
        model.setViewName("chooseStudent");
        model.addObject(DAO.class);
        return model;
    }


/*
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<StudentEntity> studenten = dao.findAllStudents();
        model.addAttribute("studenten", studenten);

        return "index";
    }
*/
}