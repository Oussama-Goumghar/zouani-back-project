package ma.learn.quiz.rest;

import ma.learn.quiz.bean.Prof;
import ma.learn.quiz.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centre/prof")
public class ProfRest {
    @GetMapping("/numero/{numro}")
    public Prof findByNumero(@PathVariable String ref) {
        return profService.findByNumero(ref);
    }
@DeleteMapping("/numero/{numero}")
    public int deleteByNumero(@PathVariable String ref) {
        return profService.deleteByNumero(ref);
    }

    public List<Prof> findAll() {
        return profService.findAll();
    }
@PostMapping("/")
    public int save(@RequestBody Prof prof) {
        return profService.save(prof);
    }

    @Autowired
    private ProfService profService;
}
