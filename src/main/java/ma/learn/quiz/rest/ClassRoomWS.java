package ma.learn.quiz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.learn.quiz.bean.ClassRoom;
import ma.learn.quiz.dao.ClassRoomDao;
import ma.learn.quiz.service.ClassRoomService;

@RestController
@RequestMapping("learn/classRoom")
public class ClassRoomWS {
	@Autowired
	private ClassRoomService classRoomService;
@GetMapping("/Prof/id/{id}")
	public List<ClassRoom> findByResponsableId(@PathVariable Long id) {
		return classRoomService.findByResponsableId(id);
	}
@GetMapping("/")
	public List<ClassRoom> findAll() {
		return classRoomService.findAll();
	}
	
}
