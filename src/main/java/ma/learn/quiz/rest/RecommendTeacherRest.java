package ma.learn.quiz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.learn.quiz.bean.RecommendTeacher;
import ma.learn.quiz.service.RecommendTeacherService;

@RestController
@RequestMapping("learn/teacher")
public class RecommendTeacherRest {
	@Autowired
	private RecommendTeacherService recommendTeacherService ;
	 @GetMapping("/ref/{ref}")
	public RecommendTeacher findByRef(@PathVariable String ref) {
		return recommendTeacherService.findByRef(ref);
	}
	 @GetMapping("/")
	public List<RecommendTeacher> findAll() {
		return recommendTeacherService.findAll();
	}
	 @PostMapping("/")
	public int save(@RequestBody RecommendTeacher recommendTeacher) {
		return recommendTeacherService.save(recommendTeacher);
	}
	
	

}
