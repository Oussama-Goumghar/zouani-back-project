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

import ma.learn.quiz.bean.FaqType;
import ma.learn.quiz.service.FaqTypeService;

@RestController
@RequestMapping("learn/faqType")
public class FaqTypeRest {

	@Autowired
	private FaqTypeService faqTypeService;

	@GetMapping("/ref/{ref}")
	public FaqType findByRef(@PathVariable String ref) {
		return faqTypeService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@RequestBody String ref) {
		return faqTypeService.deleteByRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody FaqType faqType) {
		return faqTypeService.save(faqType);
	}

	@GetMapping("/")
	public List<FaqType> findAll() {
		return faqTypeService.findAll();
	}
}
