package ma.learn.quiz.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.learn.quiz.bean.Reponse;
import ma.learn.quiz.service.ReponseService;
import ma.learn.quiz.vo.ReponseVo;

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

    
    @GetMapping("/etatReponse/{etatReponse}")
	public List<Reponse> findByEtatReponse(@PathVariable String etatReponse) {
		return reponseService.findByEtatReponse(etatReponse);
	}
    
	@GetMapping("/question/numero/{numero}")
	public List<Reponse> findByQuestionNumero(@PathVariable Long numero) {
		return reponseService.findByQuestionNumero(numero);
	}
	
	@GetMapping("/criteria/numero/{numero}")
	public List<Reponse> findByCriterial(@PathVariable Long numero) {
		return reponseService.findByCriterial(numero);
	}

}
