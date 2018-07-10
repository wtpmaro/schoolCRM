package springbootschool.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootschool.school.entity.Exams;
import springbootschool.school.entity.StudentList;
import springbootschool.school.repository.StudentListRepository;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    StudentListRepository studentListRepository;


    @GetMapping("/all")
    public String showAll(Model model) {

        model.addAttribute("users",studentListRepository.findAll());
        return "UserList";
    }

    @GetMapping("/add")
    public String userForm(Model model) {

        model.addAttribute("studentList", new StudentList());
        return "UserForm";
}

    @PostMapping("/add")
    @ResponseBody
    public String userForm(@ModelAttribute StudentList studentList) {
            studentListRepository.save(studentList);
        return "redirect:/user/all";
    }

}