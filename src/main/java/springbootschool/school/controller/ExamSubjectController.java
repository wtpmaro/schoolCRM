package springbootschool.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springbootschool.school.entity.ExamSubject;
import springbootschool.school.entity.Exams;
import springbootschool.school.entity.StudentList;
import springbootschool.school.repository.ExamSubjectRepository;
import springbootschool.school.repository.ExamsRepository;
import springbootschool.school.repository.StudentListRepository;

import java.util.List;


@Controller
@RequestMapping("/subject")
public class ExamSubjectController {


    @Autowired
    ExamSubjectRepository examSubjectRepository;

    @GetMapping("/all")
    public String showAll(Model model) {

        model.addAttribute("exams",examSubjectRepository.findAll());
        return "SubjectList";
    }

    @GetMapping("/add")
    public String userForm(Model model) {

        model.addAttribute("exams", new ExamSubject());

        return "ExamsSubjectForm";
}

    @PostMapping("/add")
    @ResponseBody
    public String examSubjectForm(@ModelAttribute ExamSubject exams, BindingResult result) {

        examSubjectRepository.save(exams);
        return "Zapisano";
    }

}