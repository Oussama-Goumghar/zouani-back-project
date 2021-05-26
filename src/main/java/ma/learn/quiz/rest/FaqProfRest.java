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

import ma.learn.quiz.bean.FaqProf;
import ma.learn.quiz.service.FaqProfService;

@RestController
@RequestMapping("learn/faqProf")
public class FaqProfRest {

	@Autowired
	private FaqProfService faqProfService;

	@PutMapping("/")
	public void update(@RequestBody FaqProf faqProf) {
		faqProfService.update(faqProf);
	}

	@GetMapping("/ref/{ref}")
	public FaqProf findByRef(@PathVariable String ref) {
		return faqProfService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return faqProfService.deleteByRef(ref);
	}

	@GetMapping("/faqType/ref/{ref}")
	public List<FaqProf> findByFaqTypeRef(@PathVariable String ref) {
		return faqProfService.findByFaqTypeRef(ref);
	}

	@DeleteMapping("/faqType/ref/{ref}")
	public int deleteByFaqTypeRef(@PathVariable String ref) {
		return faqProfService.deleteByFaqTypeRef(ref);
	}

	@GetMapping("/prof/ref/{ref}")
	public List<FaqProf> findByProfRef(@PathVariable String ref) {
		return faqProfService.findByProfRef(ref);
	}

	@DeleteMapping("/prof/ref/{ref}")
	public int deleteByProfRef(@PathVariable String ref) {
		return faqProfService.deleteByProfRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody FaqProf faqProf) {
		return faqProfService.save(faqProf);
	}

	@GetMapping("/")
	public List<FaqProf> findAll() {
		return faqProfService.findAll();
	}

	
}
