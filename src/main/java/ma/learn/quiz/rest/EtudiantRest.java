package ma.learn.quiz.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.service.EtudiantService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "centre/etudiant")
public class EtudiantRest {
	@Autowired
	private EtudiantService etudiantService;

	@GetMapping("/ref/{ref}")
	public Etudiant findByRef(@PathVariable String ref) {
		return etudiantService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return etudiantService.deleteByRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody Etudiant etudiant) {
		return etudiantService.save(etudiant);
	}

	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}


}
