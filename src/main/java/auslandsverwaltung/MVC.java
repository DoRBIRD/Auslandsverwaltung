package auslandsverwaltung;

import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MVC {

    @Autowired
    private DAO dao;

    @RequestMapping(value = {"index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("views/index");
        List<StudentEntity> studenten = dao.findAllStudents();
        model.addObject("studenten", studenten);
        model.addObject("test", "test");
        model.addObject(DAO.class);

        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        System.out.println("Receive flash map with {} elements=" + (flashMap != null ? flashMap.size() : 0));
        if (flashMap != null) {
            Object statusMessage = flashMap.get("message");
            model.addObject("flashMessage", flashMap.get("message"));
            model.addObject("flashMessageType", flashMap.get("type"));
            System.out.println("Received statusMessage attribute {} "+statusMessage);
        }

        return model;
    }

    @RequestMapping("/")
    public String visitHome() {
        // mappt "/" auf home
        return "views/index";
    }

    @RequestMapping(value = {"studentenliste"}, method = RequestMethod.GET)
    public ModelAndView studentenListe() {
        ModelAndView model = new ModelAndView();
        List<StudentEntity> studenten = dao.findAllStudents();
        model.addObject("studenten", studenten);
        model.addObject("test", "test");
        model.setViewName("views/studentenliste");
        model.addObject(DAO.class);
        return model;
    }

    @RequestMapping(value = {"chooseStudent"}, method = RequestMethod.GET)
    public ModelAndView chooseStudent() {
        ModelAndView model = new ModelAndView();
        List<StudentEntity> studenten = dao.findAllStudents();
        model.addObject("studenten", studenten);
        model.addObject("test", "test");
        model.setViewName("views/studentenliste");
        model.addObject(DAO.class);
        return model;
    }

    @RequestMapping(value = {"hochschulliste"}, method = RequestMethod.GET)
    public ModelAndView hochschuleliste() {
        ModelAndView model = new ModelAndView();
        List<UniversitaetEntity> universities = dao.findAllUniversities();
        model.addObject("universities", universities);
        model.addObject("test", "test");
        model.setViewName("views/hochschulliste");
        model.addObject(DAO.class);
        return model;
    }

    @RequestMapping(value = {"hochschule"}, method = RequestMethod.GET)
    public ModelAndView hochschule(@RequestParam(value = "hochschulId", required = false, defaultValue = "-1") int universities) {
        ModelAndView model = new ModelAndView();

        UniversitaetEntity university = dao.findUniversityById(universities);
        model.addObject("university", university);

        List<StudiengangEntity> studiengangListe = dao.findStudeiengangByUniId(universities);
        model.addObject("studiengangListe", studiengangListe);

        List<StudienplatzEntity> studienplatzListe = dao.findStudeienplatzByUniId(universities);
        model.addObject("studienplatzListe", studienplatzListe);

        List<StudentEntity> studentenListe = dao.findStudentByUniversityId2(universities);
        model.addObject("studentenListe", studentenListe);

        model.setViewName("views/hochschule");
        model.addObject(DAO.class);
        model.addObject("dao", dao);
        return model;
    }

    @RequestMapping(value = {"student"}, method = RequestMethod.GET)
    public ModelAndView student(@RequestParam(value = "studentId", required = false, defaultValue = "-1") int studentId) {
        ModelAndView model = new ModelAndView();
        StudentEntity student = dao.findStudentById(studentId);
        model.addObject("student", student);
        List<StudiengangEntity> sg = dao.findStudeiengangByStudentId(studentId);
        model.addObject("studiengaenge", sg);
        model.setViewName("views/student");
        return model;
    }

    @RequestMapping(value = {"laenderliste"}, method = RequestMethod.GET)
    public ModelAndView laenderlist() {
        ModelAndView model = new ModelAndView();
        List<LandEntity> laenderListe = dao.findAllLands();
        model.addObject("laenderListe", laenderListe);
        model.setViewName("views/laenderliste");
        return model;
    }


    @RequestMapping(value = {"land"}, method = RequestMethod.GET)
    public ModelAndView land(@RequestParam(value = "landId", required = false, defaultValue = "-1") String landId) {
        ModelAndView model = new ModelAndView();
        LandEntity land = dao.findLandById(landId);
        model.addObject("land", land);
        List<UniversitaetEntity> hochschulListe = dao.findUniversityByStandort(landId);
        model.addObject("hochschulListe", hochschulListe);
        model.setViewName("views/land");
        return model;
    }

    @RequestMapping(value = {"allData"}, method = RequestMethod.GET)
    public ModelAndView allData() {
        ModelAndView model = new ModelAndView();

        List<LandEntity> laenderListe = dao.findAllLands();
        model.addObject("laenderListe", laenderListe);

        List<UniversitaetEntity> universities = dao.findAllUniversities();
        model.addObject("universities", universities);

        List<StudentEntity> studentenliste = dao.findAllStudents();
        model.addObject("studentenliste", studentenliste);

        List<StudiengangEntity> studiengangliste = dao.findAllStudiengaenge();
        model.addObject("studiengangliste", studiengangliste);

        List<StudienplatzEntity> studienplatzliste = dao.findAllStudienplaetze();
        model.addObject("studienplatzliste", studienplatzliste);

        model.setViewName("views/allData");
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
