package ma.learn.quiz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.CoursItem;
import ma.learn.quiz.bean.ParcoursItem;
import ma.learn.quiz.service.CoursItemService;

@RestController
@RequestMapping("E-learning/coursItem")
public class CoursItemWS {
	  @Autowired
	    public CoursItemService coursItemService;

	    @PostMapping("/")
	public void save(@RequestBody Cours cours, List<CoursItem> coursItems) {
		coursItemService.save(cours, coursItems);
	}

	    @GetMapping("/code/{code}")
	public List<CoursItem> findByCoursCode(@PathVariable String code) {
		return coursItemService.findByCoursCode(code);
	}
	    @DeleteMapping("/code/{code}")
	public int deleteByCoursCode(@PathVariable String code) {
		return coursItemService.deleteByCoursCode(code);
	}
	    @GetMapping("/")
	public List<CoursItem> findAll() {
		return coursItemService.findAll();
	}
	    @DeleteMapping("/")
	public void deleteAll() {
		coursItemService.deleteAll();
	}
	  
}
