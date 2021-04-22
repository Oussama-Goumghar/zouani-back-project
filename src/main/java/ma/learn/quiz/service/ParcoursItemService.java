package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.ParcoursItem;
import ma.learn.quiz.dao.ParcoursItemDao;
@Service
public class ParcoursItemService {
	@Autowired
    private ParcoursItemDao parcoursItemDao;
	@Autowired
    private CoursService coursService;
	
	public void save(Parcours parcours, List<ParcoursItem> parcoursItems) {
		for (ParcoursItem parcoursItem:parcoursItems) {
			parcoursItem.setCode(parcoursItem.getCode());
			parcoursItem.setParcours(parcours);
			if(parcoursItem.getCours() != null && parcoursItem.getCours().getCode()!= null) {
				parcoursItem.setCours(coursService.findByCode(parcoursItem.getCours().getCode()));
				
			}
			
			parcoursItemDao.save(parcoursItem);
		}
		
	}

	public List<ParcoursItem> findByParcoursCode(String code) {
		return parcoursItemDao.findByParcoursCode(code);
	}

	public int deleteByParcoursCode(String code) {
		return parcoursItemDao.deleteByParcoursCode(code);
	}

	public List<ParcoursItem> findAll() {
		return parcoursItemDao.findAll();
	}

	public void deleteAll() {
		parcoursItemDao.deleteAll();
	}

	
}
