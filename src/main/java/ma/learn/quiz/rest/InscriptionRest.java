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

import ma.learn.quiz.bean.Inscription;
import ma.learn.quiz.service.InscriptionService;




@RestController
@RequestMapping("learn/inscription")
public class InscriptionRest {
	@Autowired
	public  InscriptionService  inscriptionService;
	@PostMapping("/")
	public int save(@RequestBody Inscription inscriptionetudiant) {
		return inscriptionService.save(inscriptionetudiant);
	}
	
	@GetMapping("/")
	public List<Inscription> findAll() {
		return inscriptionService.findAll();
	}


	@DeleteMapping("/numeroInscription/{numeroInscription}")
	public int deleteByNumeroInscription(@PathVariable int numeroInscription) {
		return inscriptionService.deleteByNumeroInscription(numeroInscription);
	}
	

	@GetMapping("/numeroInscription/{numeroInscription}")
	public Inscription findByNumeroInscription(@PathVariable int numeroInscription) {
		return inscriptionService.findByNumeroInscription(numeroInscription);
	}

	

	@GetMapping("/Etudiant/ref/{ref}")
	public Inscription findByEtudiantRef(@PathVariable String ref) {
		return inscriptionService.findByEtudiantRef(ref);
	}

@PutMapping("/")
	public int valider(@RequestBody Inscription inscription) {
		return inscriptionService.valider(inscription);
	}

	
	
}
