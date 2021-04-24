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

import ma.learn.quiz.bean.Section;
import ma.learn.quiz.service.SectionService;

@RestController
@RequestMapping("E-learning/section")
public class SectionWS {

    @GetMapping("/")
    public List<Section> findAll( ) {
        return sectionservice.findAll();
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return sectionservice.deleteByRef(ref);
    }

   

    @Autowired
    private SectionService sectionservice;
    @PostMapping("/")
    public int save(@RequestBody Section section) {
        return sectionservice.save(section);
    }
    @GetMapping("/ref/{ref}")
    public Section findByRef(@PathVariable String ref) {
        return sectionservice.findByRef(ref);
    }

    

    @PutMapping("/")
    public void update(@RequestBody Section section) {
        sectionservice.update(section);
    }

    
    
}
