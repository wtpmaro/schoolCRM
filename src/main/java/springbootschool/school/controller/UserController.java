package springbootschool.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootschool.school.entity.Exams;
import springbootschool.school.entity.StudentList;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/add")
public String userForm(Model model) {

        model.addAttribute("studentList", new StudentList());
        return "ExamsForm";
}
}