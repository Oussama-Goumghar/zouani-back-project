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

import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.ParcoursItem;
import ma.learn.quiz.service.ParcoursItemService;
@RestController
@RequestMapping("E-learning/parcoursItem")
public class ParcoursItemWS {
	@Autowired
    public ParcoursItemService parcoursItemService;

	 @PostMapping("/")
	public void save(@RequestBody Parcours parcours, List<ParcoursItem> parcoursItems) {
		parcoursItemService.save(parcours, parcoursItems);
	}

	@GetMapping("/code/{code}")
	public List<ParcoursItem> findByParcoursCode(@PathVariable String code) {
		return parcoursItemService.findByParcoursCode(code);
	}

	@DeleteMapping("/code/{code}")
	public int deleteByParcoursCode(@PathVariable String code) {
		return parcoursItemService.deleteByParcoursCode(code);
	}

	public List<ParcoursItem> findAll() {
		return parcoursItemService.findAll();
	}

	@GetMapping("/")
	public void deleteAll() {
		parcoursItemService.deleteAll();
	}
	
}
