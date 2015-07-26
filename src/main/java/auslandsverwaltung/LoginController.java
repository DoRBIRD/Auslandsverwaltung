package auslandsverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user/")
public class LoginController {

    @Autowired
    private DAO dao;

    //@Autowired private DAO dao;
    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    public String login_function(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        StudentEntity student = dao.findStudentByUserPass(username, password);
        if (student != null) {
            HttpSession session = request.getSession();
            session.setAttribute("UserName", student.Username());
            redirectAttributes.addFlashAttribute("type", "success");
            redirectAttributes.addFlashAttribute("message", "Login erfolgreich");

            return "redirect:/index";
        } else {
            redirectAttributes.addFlashAttribute("type", "danger");
            redirectAttributes.addFlashAttribute("message", "Login fehlgeschlagen");
        }

        return "redirect:/index";
    }

    @RequestMapping(value = {"logout"}, method = RequestMethod.GET)
    public String logout(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        request.getSession().invalidate();

        redirectAttributes.addFlashAttribute("type", "success");
        redirectAttributes.addFlashAttribute("message", "Logout erfolgreich");

        return "redirect:/index";
    }

}
