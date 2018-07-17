package springbootschool.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping
    @ResponseBody
    public String helloWorld() {

        return "FOR EVERYONE";
    }
    @GetMapping("table1")
    public String table1(){

        return "table1";
    }

    @GetMapping("/remove")
    @ResponseBody
    public String remove(){

        return "Remove";
    }
}
