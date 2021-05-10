package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.ClassRoom;
import ma.learn.quiz.dao.ClassRoomDao;

@Service
public class ClassRoomService {
	@Autowired
	private ClassRoomDao classRoomDao;
	@Autowired
	private ProfService profService;
	
	public List<ClassRoom> findByResponsableId(Long id) {
		return classRoomDao.findByResponsableId(id);
	}
	public List<ClassRoom> findAll() {
		return classRoomDao.findAll();
	}
	
}
