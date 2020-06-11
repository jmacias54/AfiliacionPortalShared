package mx.profuturo.ap.middle.web.controller;

import io.swagger.annotations.Api;
import mx.profuturo.ap.middle.web.util.UtilConversor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
@Api(basePath = "/", value = "index", tags = { "index" }, description = "index")
public class IndexController extends UtilConversor {
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping(value = "/")
    public String listEmployee(Model model)  {
        logger.info(" --- index --- ");
        return "index";
    }
 

}
