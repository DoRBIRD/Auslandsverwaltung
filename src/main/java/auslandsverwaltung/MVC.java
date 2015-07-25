package auslandsverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class MVC {

    @Autowired private DAO dao;
    @RequestMapping(value = {"/index", "/index.jsp"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        List<StudentEntity> studenten = dao.findAllStudents();
        model.addObject("studenten", studenten);
        model.addObject("test", "test");
        model.setViewName("views/index");
        model.addObject(DAO.class);
        return model;
    }

    @RequestMapping("/")
    public String visitHome() {
        // mappt "/" auf home
        return "views/home";
    }

    @RequestMapping(value = {"/studentenliste"}, method = RequestMethod.GET)
    public ModelAndView studentenListe() {
        ModelAndView model = new ModelAndView();
        List<StudentEntity> studenten = dao.findAllStudents();
        model.addObject("studenten", studenten);
        model.addObject("test","test");
        model.setViewName("views/studentenliste");
        model.addObject(DAO.class);
        return model;
    }

    @RequestMapping(value = {"/chooseStudent"}, method = RequestMethod.GET)
    public ModelAndView chooseStudent() {
        ModelAndView model = new ModelAndView();
        List<StudentEntity> studenten = dao.findAllStudents();
        model.addObject("studenten", studenten);
        model.addObject("test","test");
        model.setViewName("views/chooseStudent");
        model.addObject(DAO.class);
        return model;
    }

    @RequestMapping(value = {"/hochschulliste", "hochschulliste", "hochschulliste.jsp"}, method = RequestMethod.GET)
    public ModelAndView hochschulliste() {
        ModelAndView model = new ModelAndView();
        List<UniversitaetEntity> universities = dao.findAllUniversities();
        model.addObject("universities", universities);
        model.addObject("test","test");
        model.setViewName("views/hochschulliste");
        model.addObject(DAO.class);
        return model;
    }

    @RequestMapping(value = {"/student"}, method = RequestMethod.GET)
    public ModelAndView student(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        StudentEntity student = dao.findStudentById(id);
        model.addObject("student",student);
        model.setViewName("views/student");
        return model;
    }

    //@Autowired private DAO dao;
    @RequestMapping(value = {"/login_function"}, method = RequestMethod.POST)
    public ModelAndView login_function(@RequestParam("username") String username,@RequestParam("password") String password) {

        ModelAndView model = new ModelAndView();
        StudentEntity student = dao.findStudentByUserPass(username, password);
        model.addObject("student",student);
        model.addObject("testVar",username);
        model.addObject("testVar2",password);
        model.setViewName("views/login_function");
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