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

import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.service.EtudiantService;



@RestController
@RequestMapping("learn/etudiant")
public class EtudiantRest {
	@Autowired
	public EtudiantService  etudiantService;
	
	@GetMapping("/parcours/code/{code}")
	public List<Etudiant> findByParcoursCode(@PathVariable String code) {
		return etudiantService.findByParcoursCode(code);
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
	
	
	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}
	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(String ref) {
		return etudiantService.deleteByRef(ref);
	}
	@PutMapping("/")
	public void valider(@RequestBody Etudiant etudiant) {
		etudiantService.valider(etudiant);
	}
	

}
