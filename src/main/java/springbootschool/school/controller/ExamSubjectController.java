package springbootschool.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springbootschool.school.entity.ExamSubject;
import springbootschool.school.repository.ExamSubjectRepository;

import javax.validation.Valid;


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

        return "Subject/ExamsSubject";
}

    @PostMapping("/add")
    public String examSubjectForm(@Valid ExamSubject exams, BindingResult result) {

        if (result.hasErrors()) {
            return "Subject/ExamsSubject";
        }
        examSubjectRepository.save(exams);
        return "redirect:/subject/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        examSubjectRepository.findById(id).ifPresent(exams -> {

            model.addAttribute("exams", exams);
        });
        return "Subject/ExamsSubject";
    }

    @PostMapping("/{id}/edit")
    public String edit(@Valid ExamSubject exams, BindingResult result){
             if(result.hasErrors()){
            return "Subject/ExamsSubject";
        }
        examSubjectRepository.save(exams);
        return "redirect:/subject/all";
    }

    @PostMapping("/search")
    @ResponseBody
    public String search(Model model, @RequestParam String criteria) {

        return "User/UserList";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        examSubjectRepository.deleteById(id);
        return "redirect:/subject/all";
    }

}