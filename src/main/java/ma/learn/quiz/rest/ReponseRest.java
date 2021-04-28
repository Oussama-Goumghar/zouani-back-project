package ma.learn.quiz.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.learn.quiz.bean.Reponse;
import ma.learn.quiz.service.ReponseService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "centre/reponse")
public class ReponseRest {
    @GetMapping("/question/ref/{ref}")
    public List<Reponse> findByQuestionRef(@PathVariable String ref) {
        return reponseService.findByQuestionRef(ref);
    }
    @GetMapping("/ref/{ref}")
    public Reponse findByRef(@PathVariable String ref) {
        return reponseService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")

    public int deleteByRef(@PathVariable String ref) {
        return reponseService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<Reponse> findAll() {
        return reponseService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Reponse reponse) {
        return reponseService.save(reponse);
    }

    @Transactional
    @DeleteMapping("/question/ref/{ref}")
    public int deleteByQuestionRef(@PathVariable String ref) {
        return reponseService.deleteByQuestionRef(ref);
    }

    @Autowired
    private ReponseService reponseService;

    @GetMapping("/question/numero/{numero}")
	public List<Reponse> findByQuestionNumero(Long numero) {
		return reponseService.findByQuestionNumero(numero);
	}

}
