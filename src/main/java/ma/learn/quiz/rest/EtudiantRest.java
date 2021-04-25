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

import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.service.EtudiantService;



@RestController
@RequestMapping("learn/etudiant")
public class EtudiantRest {
	@Autowired
	public EtudiantService  etudiantService;
	
	@GetMapping("/parcours/code/{code}")
	public List<Etudiant> findByParcoursRef(@PathVariable String ref) {
		return etudiantService.findByParcoursRef(ref);
	}
	@PostMapping("/")
	public int save(@RequestBody Etudiant etudiant) {
		return etudiantService.save(etudiant);
	}
	@GetMapping("/ref/{ref}")
	public Etudiant findByref(@PathVariable String ref) {
		return etudiantService.findByref(ref);
	}
	@GetMapping("/nom/{nom}")
	public Etudiant findBynom(@PathVariable String nom) {
		return etudiantService.findBynom(nom);
	}
	@DeleteMapping("/ref/{ref}")
	public int deleteByref(@PathVariable String ref) {
		return etudiantService.deleteByref(ref);
	}
	@DeleteMapping("/nom/{nom}")
	public int deleteBynom(@PathVariable String nom) {
		return etudiantService.deleteBynom(nom);
	}
	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}
	

}
