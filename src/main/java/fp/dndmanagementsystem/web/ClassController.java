package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.repo.ClassRepository;
import fp.dndmanagementsystem.service.ClassService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController {
    private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }
}
