package ma.learn.quiz.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.learn.quiz.bean.Dictionary;
import ma.learn.quiz.service.DictionaryService;

@RestController
@RequestMapping("learn/dictionary")
public class DictionaryRest {
	@Autowired
	private DictionaryService dictionaryService;
	@GetMapping("/word/{word}")
	public Dictionary findByWord(@PathVariable String word) {
		return dictionaryService.findByWord(word);
	}
	@GetMapping("/id/{id}")
	public Dictionary findDictionaryById(@PathVariable Long id) {
		return dictionaryService.findDictionaryById(id);
	}
	@GetMapping("/")
	public List<Dictionary> findAll() {
		return dictionaryService.findAll();
	}
	@PostMapping("/")
	public int save(@RequestBody Dictionary dictionary) {
		return dictionaryService.save(dictionary);
	}
	

}