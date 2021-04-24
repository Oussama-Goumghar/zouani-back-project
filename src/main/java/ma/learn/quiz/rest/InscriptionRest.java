package ma.learn.quiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@DeleteMapping("/numeroInscription/{numeroInscription}")
	public int deleteBynumeroInscription(@PathVariable String numeroInscription) {
		return inscriptionService.deleteBynumeroInscription(numeroInscription);
	}
	@DeleteMapping("/ref/{ref}")
	public int deleteByref(@PathVariable String ref) {
		return inscriptionService.deleteByref(ref);
	}

	@GetMapping("/numeroInscription/{numeroInscription}")
	public Inscription findBynumeroInscription(@PathVariable String numeroInscription) {
		return inscriptionService.findBynumeroInscription(numeroInscription);
	}

	@GetMapping("/ref/{ref}")
	public Inscription findByref(@PathVariable String ref) {
		return inscriptionService.findByref(ref);
	}
	

}
