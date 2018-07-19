package springbootschool.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springbootschool.school.entity.StudentList;
import springbootschool.school.repository.StudentListRepository;


@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    StudentListRepository studentListRepository;


    @GetMapping("/all")
    public String showAll(Model model) {

        model.addAttribute("users",studentListRepository.findAll());
        return "User/UserList";
    }

    @GetMapping("/add")
    public String userForm(Model model) {

        model.addAttribute("studentList", new StudentList());
        return "UserForm";
}

    @PostMapping("/add")
    public String userForm(@ModelAttribute StudentList studentList) {
            studentListRepository.save(studentList);
        return "redirect:/user/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        studentListRepository.findById(id).ifPresent(studentList -> {

            model.addAttribute("studentList", studentList);
        });
        return "UserForm";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute StudentList studentList, BindingResult result){
/*        if(result.hasErrors()){

            return "ExamsForm";
        }*/
        studentListRepository.save(studentList);
        return "redirect:/user/all";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        studentListRepository.deleteById(id);
        return "redirect:/user/all";
    }
}