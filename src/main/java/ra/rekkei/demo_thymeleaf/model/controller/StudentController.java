package ra.rekkei.demo_thymeleaf.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ra.rekkei.demo_thymeleaf.model.entity.Student;
import ra.rekkei.demo_thymeleaf.model.service.StudentService;
import ra.rekkei.demo_thymeleaf.model.service.UploadFile;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UploadFile uploadFile;

    @RequestMapping(value = {"/","listStudents"})
    public String home(Model model){
        List<Student> list = studentService.findAll();
        model.addAttribute("list",list);
        return "listStudent";
    }

    @RequestMapping("/list1")
    public String list1(Model model){
        return "product_list";
    }

    @RequestMapping("/initInsertStudent")
    public String initInsertStudent(Model model){
        Student s = new Student();
        model.addAttribute("s",s);
        return "insertStudent";
    }

    @RequestMapping("/insertStudent")
    public String insertStudent(@Valid @ModelAttribute("s")Student s, BindingResult result, @RequestParam("avatarFile") MultipartFile file, Model model){
        if(result.hasErrors()){
            model.addAttribute("s",s);
            return "insertStudent";
        }else{
            //upload avatar:
            String urlAvatar = uploadFile.uploadLocal(file);
            s.setAvatar(urlAvatar);
            boolean bl = studentService.save(s);
            if(bl){
                return "redirect:/listStudents";
            }else{
                model.addAttribute("s",s);
                model.addAttribute("error","Insert failed!");
                return "insertStudent";
            }
        }
    }
}
