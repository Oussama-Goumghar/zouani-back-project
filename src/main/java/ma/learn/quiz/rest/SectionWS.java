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

import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Section;
import ma.learn.quiz.service.SectionService;

@RestController
@RequestMapping("learn/section")
public class SectionWS {
 @Autowired
    private SectionService sectionservice;
 @PostMapping("/delete-multiple-by-id")
    public int deleteSectionById(@RequestBody List<Section> sections) {
	return sectionservice.deleteSectionById(sections);
}
	@GetMapping("/")
    public List<Section> findAll( ) {
        return sectionservice.findAll();
    }
    @DeleteMapping("/id/{id}")
    public int deleteSectionById(@PathVariable Long id) {
		return sectionservice.deleteSectionById(id);
	}
	
    @GetMapping("/code/{code}")
    public Section findByCode(@PathVariable String code) {
        return sectionservice.findByCode(code);
    }

    @DeleteMapping("/cours/code/{code}")
	public int deleteByCoursCode(@PathVariable String code) {
		return sectionservice.deleteByCoursCode(code);
	}

	@PutMapping("/")
    public Section update(@RequestBody Section section) {
        return sectionservice.update(section);
    }

	@GetMapping("/cours/code/{code}")
	public List<Section> findByCoursCode(@PathVariable String code) {
		return sectionservice.findByCoursCode(code);
	}
	@GetMapping("/cours/id/{id}")
	public List<Section> findByCoursId(@PathVariable Long id) {
		return sectionservice.findByCoursId(id);
	}
	@GetMapping("/libelle/{libelle}")
	public List<Section> findByLibelle(@PathVariable String libelle) {
		return sectionservice.findByLibelle(libelle);
	}
	@GetMapping("/section/id/{id}")
	public Section findSectionById(@PathVariable Long id) {
		return sectionservice.findSectionById(id);
	}
	

    
    
}
