package ma.learn.quiz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.learn.quiz.bean.Temps;
import ma.learn.quiz.service.Tempsservice;



@RestController
@RequestMapping("Centre/Horaireinscription")
public class Tempsprovided {
	@Autowired
	public Tempsservice horaireservice;
	@GetMapping("/")
	public List<Temps> findAll() {
		return horaireservice.findAll();
	}
	@GetMapping("/ref/{ref}")
	public Temps findHoraireByref(String ref) {
		return horaireservice.findHoraireByref(ref);
	}
	
	

}
