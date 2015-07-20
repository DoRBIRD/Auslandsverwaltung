package de.hsb.auslandsverwaltung;

/**
 * Created by Niklas on 19.07.2015.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView getHome() {
        String string = "Congrats ! You are done with your first Spring Security configuration !";
        return new ModelAndView("home", "string", string);
    }

}