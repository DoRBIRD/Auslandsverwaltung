package auslandsverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
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
        if (flashMap != null) {
            model.addObject("flashMessage", flashMap.get("message"));
            model.addObject("flashMessageType", flashMap.get("type"));
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
    public ModelAndView hochschule(@RequestParam(value = "hochschulId", required = false, defaultValue = "-1") int uniId,
                                   @RequestParam(value = "studentId", required = false, defaultValue = "-1") int studentId) {
        ModelAndView model = new ModelAndView();
        UniversitaetEntity university;
        if(studentId > 0){
            university = dao.findUniversityByStudentId(studentId).get(0);
            uniId = university.getId();
        }else university = dao.findUniversityById(uniId);
        model.addObject("university", university);

        List<StudiengangEntity> studiengangListe = dao.findStudeiengangByUniId(uniId);
        model.addObject("studiengangListe", studiengangListe);

        List<StudienplatzEntity> studienplatzListe = dao.findStudeienplatzByUniId(uniId);
        model.addObject("studienplatzListe", studienplatzListe);

        List<StudentEntity> studentenListe = dao.findStudentByUniversityId(uniId);
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
        List<UniversitaetEntity> unis = dao.findUniversityByStudentId(studentId);
        model.addObject("unis", unis);
        model.setViewName("views/student");
        return model;
    }

    @RequestMapping(value = "Profil/studId={studentId}", method = RequestMethod.GET)
    public @ResponseBody ModelAndView Profil(@PathVariable(value="studentId") int id) {
        ModelAndView model = new ModelAndView();
        StudentEntity student = dao.findStudentById(id);
        model.addObject("student", student);
        List<StudiengangEntity> sg = dao.findStudeiengangByStudentId(id);
        model.addObject("studiengaenge", sg);

        model.setViewName("views/Profil");
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

    @RequestMapping(value = {"studienplatzliste"}, method = RequestMethod.GET)
    public ModelAndView studienplatzliste(@RequestParam(value = "studentId", required = false, defaultValue = "-1") int studentId) {
        ModelAndView model = new ModelAndView();
        List<StudienplatzEntity> studienplatzliste;
        if(studentId<0) studienplatzliste = dao.findAllStudienplaetze();
        else studienplatzliste = dao.findStudeienplatzByStudentId(studentId);
        model.addObject("studienplatzliste", studienplatzliste);
        model.addObject("dao", dao);
        model.setViewName("views/studienplatzliste");
        return model;
    }

    @RequestMapping(value = "studienplatz/studId={studentId}", method = RequestMethod.GET)
    public @ResponseBody ModelAndView studienplatzByStudent(@PathVariable(value="studentId") int id) {
        ModelAndView model = new ModelAndView();
        List<StudienplatzEntity> studienplatzliste = dao.findStudeienplatzByStudentId(id);
        model.addObject("studienplatzliste", studienplatzliste);
        model.setViewName("views/studienplatzliste");
        return model;
    }

    @RequestMapping(value = {"studienplatz"}, method = RequestMethod.GET)
    public ModelAndView studienplatz(@RequestParam(value = "studienplatzId", required = false, defaultValue = "-1") int studienplatzId,
                                     @RequestParam(value = "studentId", required = false, defaultValue = "-1") int studentId) {
        ModelAndView model = new ModelAndView();
        StudienplatzEntity studienplatz;
        if(studentId<0) studienplatz = dao.findStudeienplatzById(studienplatzId);
        else studienplatz = dao.findStudeienplatzByStudentId(studentId).get(0);
        model.addObject("studienplatz", studienplatz);
        model.setViewName("views/studienplatz");
        return model;
    }

    @RequestMapping(value = {"erfahrungsberichtliste"}, method = RequestMethod.GET)
    public ModelAndView erfahrungsberichtliste(@RequestParam(value = "studentId", required = false, defaultValue = "-1") int studentId) {
        ModelAndView model = new ModelAndView();
        List<ErfahrungsberichtEntity> erfahrungsberichtliste;
        if(studentId<0)erfahrungsberichtliste = dao.findAllEhrfahrungsbericht();
        else erfahrungsberichtliste = dao.findEhrfahrungsberichtByStudentId(studentId);
        model.addObject("erfahrungsberichtliste", erfahrungsberichtliste);
        model.setViewName("views/erfahrungsberichtliste");
        return model;
    }
    @RequestMapping(value = {"erfahrungsbericht"}, method = RequestMethod.GET)
    public ModelAndView erfahrungsbericht(@RequestParam(value = "erfahrungsberichtId", required = false, defaultValue = "-1") int erfahrungsberichtId) {
        ModelAndView model = new ModelAndView();
        ErfahrungsberichtEntity erfahrungsbericht = dao.findEhrfahrungsberichtById(erfahrungsberichtId);
        model.addObject("erfahrungsbericht", erfahrungsbericht);
        StudentEntity student = dao.findStudentById(erfahrungsbericht.getStudentId());
        model.addObject("student", student);
        UniversitaetEntity uni = dao.findUniversityByStudentId(student.getId()).get(0);
        model.addObject("uni",uni);
        model.setViewName("views/erfahrungsbericht");
        return model;
    }
    @RequestMapping(value = {"erfahrungsberichterstellen"}, method = RequestMethod.GET)
    public ModelAndView erfahrungsberichterstellen() {
        ModelAndView model = new ModelAndView();
        List<StudentEntity> studentenlist = dao.findAllStudents();
        model.addObject("studentenlist", studentenlist);

        model.setViewName("views/erfahrungsberichterstellen");
        return model;
    }

    @RequestMapping(value = {"submitbericht"}, method = RequestMethod.GET)
    public String submitbericht(
            @RequestParam(value = "betreff", required = false, defaultValue = "-1") String betreff,
            @RequestParam(value = "student", required = false, defaultValue = "-1") int student,
            @RequestParam(value = "link", required = false, defaultValue = "-1") String link,
            @RequestParam(value = "inhalt", required = false, defaultValue = "-1") String inhalt
    ) {
        ErfahrungsberichtEntity eb = dao.createErfahrungsbericht(betreff, link, inhalt, student);
        return "redirect:/erfahrungsbericht?erfahrungsberichtId="+eb.getId();
    }


    @RequestMapping(value = {"studiengang"}, method = RequestMethod.GET)
    public ModelAndView studiengangId(@RequestParam(value = "studiengangId", required = false, defaultValue = "-1") int studiengangId) {
        ModelAndView model = new ModelAndView();
        StudiengangEntity studiengang = dao.findStudeiengangById(studiengangId);
        model.addObject("studiengang", studiengang);
        model.setViewName("views/studiengang");
        return model;
    }
    @RequestMapping(value = {"studiengangliste"}, method = RequestMethod.GET)
    public ModelAndView studiengangliste() {
        ModelAndView model = new ModelAndView();
        List<StudiengangEntity> studiengangliste = dao.findAllStudiengaenge();
        model.addObject("studiengangliste", studiengangliste);
        model.setViewName("views/studiengangliste");
        return model;
    }


    @RequestMapping(value = {"studienplatzsichern"}, method = RequestMethod.GET)
    public String studienplatzsichern(
            @RequestParam(value = "studienplatzId", required = false, defaultValue = "-1") int studienplatzId,
            @RequestParam(value = "studentId", required = false, defaultValue = "-1") int studentId
    ) {
        StudienplatzEntity sp = dao.updateStudienplatz(studienplatzId, studentId);
        return "redirect:/studienplatz?studienplatzId=" + sp.getId();

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

}
