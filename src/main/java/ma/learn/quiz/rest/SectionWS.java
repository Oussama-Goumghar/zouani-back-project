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

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return sectionservice.deleteByCode(code);
    }

   

    @Autowired
    private SectionService sectionservice;
    @PostMapping("/")
    public int save(@RequestBody Section section) {
        return sectionservice.save(section);
    }
    @GetMapping("/code/{code}")
    public Section findByCode(@PathVariable String code) {
        return sectionservice.findByCode(code);
    }

    

    @PutMapping("/update")
    public void update(@RequestBody Section section) {
        sectionservice.update(section);
    }
}
