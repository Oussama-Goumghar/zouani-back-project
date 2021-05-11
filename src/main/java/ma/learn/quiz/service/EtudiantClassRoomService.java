package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.EtudiantClassRoom;
import ma.learn.quiz.dao.EtudiantClassRoomDao;

@Service
public class EtudiantClassRoomService {
	@Autowired
	private EtudiantClassRoomDao etudiantClassRoomDao;

	public List<EtudiantClassRoom> findByClassRoomId(Long id) {
		return etudiantClassRoomDao.findByClassRoomId(id);
	}

	@Transactional
	public int deleteByClassRoomId(Long id) {
		return etudiantClassRoomDao.deleteByClassRoomId(id);
	}

	public List<EtudiantClassRoom> findAll() {
		return etudiantClassRoomDao.findAll();
	}
	

}
