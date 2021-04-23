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


    @GetMapping("/code/{code}")
    public Parcours findByCode(@PathVariable String code) {
		return parcoursService.findByCode(code);
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


	@DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return parcoursService.deleteByCode(code);
    }

}
