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
	public Etudiant findByRef(@PathVariable String ref) {
		return etudiantService.findByRef(ref);
	}
	@GetMapping("/nom/{nom}")
	public Etudiant findByNom(@PathVariable String nom) {
		return etudiantService.findByNom(nom);
	}
	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return etudiantService.deleteByRef(ref);
	}
	@DeleteMapping("/nom/{nom}")
	public int deleteByNom(@PathVariable String nom) {
		return etudiantService.deleteByNom(nom);
	}
	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}
	

}
