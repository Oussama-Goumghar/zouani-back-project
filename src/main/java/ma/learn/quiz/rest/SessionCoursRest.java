package ma.learn.quiz.rest;

import ma.learn.quiz.bean.SessionCours;
import ma.learn.quiz.service.SessionCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("learn/session-cours")
public class SessionCoursRest {
    @GetMapping("/numero/{numero}")
    public SessionCours findByNumero(@PathVariable String numero) {
        return sessionCoursService.findByNumero(numero);
    }
@DeleteMapping("/numero/{numero}")
    public int deleteByNumero(@PathVariable String numero) {
        return sessionCoursService.deleteByNumero(numero);
    }
    @GetMapping("/")
    public List<SessionCours> findAll() {
        return sessionCoursService.findAll();
    }
@PostMapping("/")
    public int save(@RequestBody SessionCours sessionCours) {
        return sessionCoursService.save(sessionCours);
    }

    @Autowired
    private SessionCoursService sessionCoursService;
}
