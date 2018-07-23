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
@RequestMapping("/exam")
public class ExamsController {


    @Autowired
    ExamsRepository examsRepository;

    @Autowired
    StudentListRepository studentListRepository;

    @Autowired
    ExamSubjectRepository examSubjectRepository;

    @GetMapping("/all")
    public String showAll(Model model) {

        model.addAttribute("exams",examsRepository.findAll());
        return "Exam/ExamList";
    }

    @GetMapping("/add")
    public String userForm(Model model) {

        model.addAttribute("exams", new Exams());

        return "Exam/ExamForm";
}

    @PostMapping("/add")
    public String examForm(@ModelAttribute Exams exams, BindingResult result) {
        if (result.hasErrors()) {
        return "Exam/ExamForm";
        }
        examsRepository.save(exams);
        return "redirect:/exam/all";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        examsRepository.findById(id).ifPresent(exams -> {

            model.addAttribute("exams", exams);
        });
        return "Exam/ExamForm";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute Exams exams, BindingResult result){
/*        if(result.hasErrors()){

            return "ExamsForm";
        }*/
        examsRepository.save(exams);
        return "redirect:/exam/all";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        examsRepository.deleteById(id);
        return "redirect:/exam/all";
    }

    @ModelAttribute("students")
    public List <StudentList> students(){
        return  studentListRepository.findAll();
    }

    @ModelAttribute("subjects")
    public List <ExamSubject> subjects(){
        return  examSubjectRepository.findAll();
    }
}