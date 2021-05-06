package ma.learn.quiz.rest;

import java.util.List;
import java.util.Optional;

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
    

   
  

    @GetMapping("/code/{code}")
	public Cours findByCode(@PathVariable String code) {
		return coursService.findByCode(code);
	}
    @GetMapping("/id/{id}")
    public int init(@PathVariable Long id) {
		return coursService.init(id);
	}

	@GetMapping("/libelle/{libelle}")
	public List<Cours> findByLibelle(@PathVariable String libelle) {
		return coursService.findByLibelle(libelle);
	}

	
	

    @DeleteMapping("/entity/{entity}")
	public void delete(Cours entity) {
		coursService.delete(entity);
	}
    @DeleteMapping("/id/{id}")
    public int deleteCoursById(@PathVariable Long id) {
		return coursService.deleteCoursById(id);
	}
	@GetMapping("/")
	public List<Cours> findAll() {
		return coursService.findAll();
	}

    
	@PutMapping("/")
	public void update(@RequestBody Cours cours) {
		coursService.update(cours);
	}
	
	
	@DeleteMapping("/parcours/code/{code}")
	public int deleteByParcoursCode(@PathVariable String code) {
		return coursService.deleteByParcoursCode(code);
	}

	@GetMapping("/parcours/code/{code}")
	public List<Cours> findByParcoursCode(@PathVariable String code) {
		return coursService.findByParcoursCode(code);
	}
	
	

  
}
