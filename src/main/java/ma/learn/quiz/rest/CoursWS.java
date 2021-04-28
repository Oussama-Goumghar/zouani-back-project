package ma.learn.quiz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.service.CoursService;

@RestController
@RequestMapping("E-learning/cours")

public class CoursWS {

    @Autowired
    private CoursService coursService ;

    @PostMapping("/")
    public int save(@RequestBody Cours cours) {
		return coursService.save(cours);
	}

    @GetMapping("/ref/{ref}")
	public Cours findByRef(@PathVariable String ref) {
		return coursService.findByRef(ref);
	}

   

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return coursService.deleteByRef(ref);
	}

    @DeleteMapping("/entity/{entity}")
	public void delete(Cours entity) {
		coursService.delete(entity);
	}

    @GetMapping("/")
	public List<Cours> findAll() {
		return coursService.findAll();
	}

    
	@PutMapping("/")
	public void update(@RequestBody Cours cours) {
		coursService.update(cours);
	}
	
	
	@DeleteMapping("/parcours/ref")
	public int deleteByParcoursRef(@PathVariable String ref) {
		return coursService.deleteByParcoursRef(ref);
	}
@GetMapping("/parcours")
	public List<Cours> findCoursByParcours(Parcours parcours) {
		return coursService.findCoursByParcours(parcours);
	}

  
}
