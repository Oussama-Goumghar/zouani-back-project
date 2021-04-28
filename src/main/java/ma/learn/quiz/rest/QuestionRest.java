package ma.learn.quiz.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.learn.quiz.bean.Question;
import ma.learn.quiz.service.QuestionService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "centre/question")
public class QuestionRest {

@GetMapping("/ref/{ref}")
    public Question findByRef(@PathVariable String ref) {
        return questionService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return questionService.deleteByRef(ref);
    }
@GetMapping("/")
    public List<Question> findAll() {
        return questionService.findAll();
    }
@PostMapping("/")
    public int save(@RequestBody Question question) {
        return questionService.save(question);
    }

@GetMapping("/quiz/ref/{ref}")
    public List<Question> findByQuizRef(@PathVariable String ref) {
        return questionService.findByQuizRef(ref);
    }

    @DeleteMapping("/quiz/ref/{ref}")
    public int deleteByQuizRef(@PathVariable String ref) {
        return questionService.deleteByQuizRef(ref);
    }

    @PutMapping("/")
    public void update(@RequestBody Question question) {
		questionService.update(question);
	}

    @GetMapping("/numero/{numero}")
	public Question findByNumero(@PathVariable Long numero) {
		return questionService.findByNumero(numero);
	}


	@Autowired
    private QuestionService questionService;


}
