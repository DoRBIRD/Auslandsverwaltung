package auslandsverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user/")
public class LoginActions {

    @Autowired
    private DAO dao;

    //@Autowired private DAO dao;
    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    public ModelAndView login_function(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        StudentEntity student = dao.findStudentByUserPass(username, password);
        if (student != null) {
            model.addObject("student", student);
            model.setViewName("views/login");

            HttpSession session = request.getSession();
            session.setAttribute("UserName", student.Username());
        }
        return model;
    }

    @RequestMapping(value = {"logout"}, method = RequestMethod.GET)
    public void logout(HttpServletResponse response, HttpServletRequest request) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/index");
    }

}
