package ma.learn.quiz.rest;

import ma.learn.quiz.bean.SessionCours;
import ma.learn.quiz.service.SessionCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecom-api/session")
public class SessionCoursRest {

    @GetMapping("/reference/{reference}")
    public SessionCours findByReference(String reference) {
        return sessionCoursService.findByReference(reference);
    }

    @PostMapping("/")
    public SessionCours save(@RequestBody SessionCours sessionCours) {
        return sessionCoursService.save(sessionCours);
    }

    @PutMapping("/")
    public SessionCours update(@RequestBody SessionCours sessionCours) {
        return sessionCoursService.update(sessionCours);
    }

    @GetMapping("/")
    public List<SessionCours> findAll() {
        return sessionCoursService.findAll();
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return sessionCoursService.deleteByReference(reference);
    }

    @PostMapping("/delete-multiple-by-reference")
    public int deleteByReference(@RequestBody List<SessionCours> sessionCourss) {
        return sessionCoursService.deleteByReference(sessionCourss);
    }

    @Autowired
    private SessionCoursService sessionCoursService;
}
