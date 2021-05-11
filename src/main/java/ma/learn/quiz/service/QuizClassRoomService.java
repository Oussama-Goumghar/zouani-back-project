package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.QuizClassRoom;
import ma.learn.quiz.dao.QuizClassRoomDao;

@Service
public class QuizClassRoomService {
	@Autowired
	private QuizClassRoomDao quizClassRoomdao;

	public List<QuizClassRoom> findByClassRoomId(Long id) {
		return quizClassRoomdao.findByClassRoomId(id);
	}

	@Transactional
	public int deleteByClassRoomId(Long id) {
		return quizClassRoomdao.deleteByClassRoomId(id);
	}

	public List<QuizClassRoom> findAll() {
		return quizClassRoomdao.findAll();
	}
	
	
}
