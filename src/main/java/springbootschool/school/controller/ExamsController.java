package springbootschool.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootschool.school.entity.Exams;
import springbootschool.school.repository.ExamsRepository;


@Controller
@RequestMapping("/exam")
public class ExamsController {


    @Autowired
    ExamsRepository examsRepository;


    @GetMapping("/all")
    public String showAll(Model model) {

        model.addAttribute("exams",examsRepository.findAll());
        return "ExamList";
    }

    @GetMapping("/add")
    public String userForm(Model model) {

        model.addAttribute("exams", new Exams());
        return "ExamsForm";
}

    @PostMapping("/add")
    public String egzamForm(@ModelAttribute Exams exams) {
            examsRepository.save(exams);
        return "redirect:/user/all";
    }

}