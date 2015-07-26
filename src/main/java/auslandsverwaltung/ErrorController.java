package auslandsverwaltung;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Error Controller. handles the calls for 404, 500 and 401 HTTP Status codes.
 */
@Controller
@RequestMapping(value = ErrorController.ERROR_URL, produces = MediaType.APPLICATION_XHTML_XML_VALUE)
public class ErrorController {


    /**
     * The constant ERROR_URL.
     */
    public static final String ERROR_URL = "/error";


    /**
     * The constant TILE_ERROR.
     */
    public static final String TILE_ERROR = "views/error";


    /**
     * Page Not Found.
     *
     * @return Home Page
     */
    @RequestMapping(value = "/404", produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    public ModelAndView notFound() {

        ModelAndView model = new ModelAndView(TILE_ERROR);
        model.addObject("errorCode", 404);
        model.addObject("message", "The page you requested could not be found. This location may not be current.");

        return model;
    }


    /**
     * Method not supported.
     *
     * @return Home Page
     */
    @RequestMapping(value = "/405", produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    public ModelAndView methodNotSupported(HttpServletRequest request) {

        ModelAndView model = new ModelAndView(TILE_ERROR);
        model.addObject("errorCode", 405);
        model.addObject("message", String.format("The page does not accept the actual request method (%s)", request.getMethod()));

        return model;
    }

    /**
     * Error page.
     *
     * @return the model and view
     */
    @RequestMapping(value = "/500", produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    public ModelAndView errorPage() {

        ModelAndView model = new ModelAndView(TILE_ERROR);
        model.addObject("errorCode", 500);
        model.addObject("message", "The page you requested could not be found. This location may not be current, due to the recent site redesign.");

        return model;
    }
}