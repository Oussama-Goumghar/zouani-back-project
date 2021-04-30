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

import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.service.ParcoursService;

@RestController
@RequestMapping("E-learning/parcours")

public class ParcoursWS {

    @Autowired
    public ParcoursService parcoursService;

    @GetMapping("/")
    public List<Parcours> findAll(){
        return parcoursService.findAll();
    }


    @GetMapping("/ref/{ref}")
    public Parcours findByRef(@PathVariable String ref) {
		return parcoursService.findByRef(ref);
	}


    @PostMapping("/")
	public int save(@RequestBody Parcours parcours) {
		return parcoursService.save(parcours);
	}


	@DeleteMapping("/entity/{entity}")
	public void delete(@PathVariable Parcours entity) {
		parcoursService.delete(entity);
	}


@PutMapping("/")
	public void update(@RequestBody Parcours parcours) {
		parcoursService.update(parcours);
	}

@GetMapping("/libelle/{libelle}")
	public List<Parcours> findByLibelle(@PathVariable String libelle) {
	return parcoursService.findByLibelle(libelle);
}


	@DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return parcoursService.deleteByRef(ref);
    }

}
