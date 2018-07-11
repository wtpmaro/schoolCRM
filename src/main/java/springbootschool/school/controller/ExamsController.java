package springbootschool.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootschool.school.entity.Exams;
import springbootschool.school.entity.StudentList;
import springbootschool.school.repository.ExamsRepository;
import springbootschool.school.repository.StudentListRepository;

import java.util.List;


@Controller
@RequestMapping("/exam")
public class ExamsController {


    @Autowired
    ExamsRepository examsRepository;

    @Autowired
    StudentListRepository studentListRepository;

    @GetMapping("/all")
    public String showAll(Model model) {

        model.addAttribute("exams",examsRepository.findAll());
        return "ExamList";
    }

    @GetMapping("/add")
    public String userForm(Model model) {

        model.addAttribute("exams", new Exams());
/*
        model.addAttribute("students",students());
*/
        return "ExamsForm";
}

    @PostMapping("/add")
    public String examForm(@ModelAttribute Exams exams) {

            examsRepository.save(exams);
        return "redirect:/exam/all";
    }

    @ModelAttribute("students")
    public List <StudentList> students(){
        return  studentListRepository.findAll();
    }
}