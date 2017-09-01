package az.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TemplateController {
    @RequestMapping("/")
    public String hello(){
        return "welcome";
    }

}
