package ma.learn.quiz.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.learn.quiz.bean.ReponseEtudiant;
import ma.learn.quiz.service.ReponseEtudiantService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "centre/reponseEtudiant")
public class ReponseEtudiantRest {
	
	@Autowired
	private ReponseEtudiantService reponseEtudiantService;

	@GetMapping("/ref/{ref}")
	public ReponseEtudiant findByRef(@PathVariable String ref) {
		return reponseEtudiantService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String Ref) {
		return reponseEtudiantService.deleteByRef(Ref);
	}

	@GetMapping("/question/ref/{ref}")
	public List<ReponseEtudiant> findByQuestionRef(@PathVariable String ref) {
		return reponseEtudiantService.findByQuestionRef(ref);
	}

	@GetMapping("/etudiant/ref/{ref}")
	public List<ReponseEtudiant> findByEtudiantRef(@PathVariable String ref) {
		return reponseEtudiantService.findByEtudiantRef(ref);
	}

	@DeleteMapping("/question/ref/{ref}")
	public int deleteByQuestionRef(@PathVariable String ref) {
		return reponseEtudiantService.deleteByQuestionRef(ref);
	}

	@DeleteMapping("/etudiant/ref/{ref}")
	public int deleteByEtudiantRef(@PathVariable String ref) {
		return reponseEtudiantService.deleteByEtudiantRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody ReponseEtudiant reponseEtudiant) {
		return reponseEtudiantService.save(reponseEtudiant);
	}

	@GetMapping("/")
	public List<ReponseEtudiant> findAll() {
		return reponseEtudiantService.findAll();
	}

	

}
