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

import ma.learn.quiz.bean.Faq;
import ma.learn.quiz.service.FaqService;

@RestController
@RequestMapping("learn/faq")
public class FaqRest {

	@Autowired
	private FaqService faqService;

	@GetMapping("/ref/{ref}")
	public Faq findByRef(@PathVariable String ref) {
		return faqService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@RequestBody String ref) {
		return faqService.deleteByRef(ref);
	}

	@GetMapping("/faqType/ref/{ref}")
	public List<Faq> findByFaqTypeRef(@PathVariable String ref) {
		return faqService.findByFaqTypeRef(ref);
	}

	@DeleteMapping("/faqType/ref/{ref}")
	public int deleteByFaqTypeRef(@RequestBody String ref) {
		return faqService.deleteByFaqTypeRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody Faq faq) {
		return faqService.save(faq);
	}

	@GetMapping("/")
	public List<Faq> findAll() {
		return faqService.findAll();
	}
}
