package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.CoursItem;
import ma.learn.quiz.bean.ParcoursItem;
import ma.learn.quiz.dao.CoursItemDao;

@Service
public class CoursItemService {
	@Autowired
    private CoursItemDao coursItemDao;
	@Autowired
    private SectionService sectionService;

	public void save(Cours cours, List<CoursItem> coursItems) {
		for (CoursItem coursItem:coursItems) {
			coursItem.setCode(coursItem.getCode());
			coursItem.setCours(cours);
			if(coursItem.getSection() != null && coursItem.getSection().getCode()!= null) {
				coursItem.setSection(sectionService.findByCode(coursItem.getSection().getCode()));
			}
			coursItemDao.save(coursItem);
		}
		
		
	}

	public List<CoursItem> findByCoursCode(String code) {
		return coursItemDao.findByCoursCode(code);
	}

	public int deleteByCoursCode(String code) {
		return coursItemDao.deleteByCoursCode(code);
	}

	public List<CoursItem> findAll() {
		return coursItemDao.findAll();
	}

	public void deleteAll() {
		coursItemDao.deleteAll();
	}
	

}
