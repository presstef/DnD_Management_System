package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.service.ClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    private final ClassService classService;

    public ClassesController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping()
    public String getAllClasses(Model model)
    {
        model.addAttribute("classes", classService.getAllClasses());return "classes";
    }
}
