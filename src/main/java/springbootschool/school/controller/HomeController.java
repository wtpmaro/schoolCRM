package springbootschool.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class HomeController {

    @GetMapping("form")
    public String table1(){

        return "UserForm";
    }

}
