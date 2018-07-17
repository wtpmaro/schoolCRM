package springbootschool.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("")
@Controller
public class HomeController {

    @GetMapping("table1")
    @ResponseBody
    public String table1(){

        return "table1";
    }

}
