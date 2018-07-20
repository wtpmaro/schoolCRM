package springbootschool.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springbootschool.school.entity.ExamSubject;
import springbootschool.school.repository.ExamSubjectRepository;


@Controller
@RequestMapping("/subject")
public class ExamSubjectController {


    @Autowired
    ExamSubjectRepository examSubjectRepository;

    @GetMapping("/all")
    public String showAll(Model model) {

        model.addAttribute("exams",examSubjectRepository.findAll());
        return "Subject/ExamsSubjectList";
    }

    @GetMapping("/add")
    public String userForm(Model model) {

        model.addAttribute("exams", new ExamSubject());

        return "FormEx1";
}

    @PostMapping("/add")
    public String examSubjectForm(@ModelAttribute ExamSubject exams, BindingResult result) {

        examSubjectRepository.save(exams);
        return "redirect:/subject/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        examSubjectRepository.findById(id).ifPresent(exams -> {

            model.addAttribute("exams", exams);
        });
        return "FormEx1";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute ExamSubject exams, BindingResult result){
/*        if(result.hasErrors()){

            return "ExamsForm";
        }*/
        examSubjectRepository.save(exams);
        return "redirect:/subject/all";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        examSubjectRepository.deleteById(id);
        return "redirect:/subject/all";
    }

}