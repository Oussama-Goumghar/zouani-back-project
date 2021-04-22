package ma.learn.quiz.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.dao.CoursDao;

@Service
public class CoursService {

    @Autowired
    private CoursDao coursDao ;
    @Autowired
    private CoursItemService coursItemService;
    public Cours findByCode(String code) {
		return coursDao.findByCode(code);
	}
    @Transactional
	public int deleteByCode(String code) {
		int deleteByCoursCode=coursItemService.deleteByCoursCode(code);
		int deleteByCode=coursDao.deleteByCode(code);
		return deleteByCoursCode+deleteByCode;
	}
	public int save(Cours cours) {
		if(findByCode(cours.getCode())!=null) {
			return -1;
		}else {
			
			coursDao.save(cours);
			coursItemService.save(cours,cours.getCoursItems());
			return 1;
		}
		
	}
	public List<Cours> findAll() {
		return coursDao.findAll();
	}
	@Transactional
	public void delete(Cours entity) {
		coursDao.delete(entity);
	}
	


}
