package ma.learn.quiz.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.dao.CoursDao;

@Service
public class CoursService {
	@Autowired
    private CategorieSectionService categorieSectionService;
    @Autowired
    private CoursDao coursDao ;
    @Autowired
	public SectionService sectionService;
    @Autowired
	public ParcoursService parcoursService;
    public Cours findByCode(String code) {
		return coursDao.findByCode(code);
	}
    @Transactional
	public int deleteByCode(String code) {
    	int deleteByCategorieSectionCode=categorieSectionService.deleteBySectionCode(code);
		int deleteBySectionCode=sectionService.deleteByCoursCode(code);
		int deleteByCode=coursDao.deleteByCode(code);
		return deleteByCategorieSectionCode+deleteBySectionCode+deleteByCode;
	}
	public int save(Cours cours) {
		if(findByCode(cours.getCode())!=null) {
			return -1;
		}
		Parcours parcours = parcoursService.findByCode(cours.getParcours().getCode());
	       cours.setParcours(parcours);
	       if(parcours==null) return -2;
		else {
			parcoursService.update(parcours);
			coursDao.save(cours);
			
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
	public List<Cours> findByParcoursCode(String code) {
		return coursDao.findByParcoursCode(code);
	}
	@Transactional
	public int deleteByParcoursCode(String code) {
		return coursDao.deleteByParcoursCode(code);
	}
	public void update(Cours cours) {
		coursDao.save(cours);
		
	}
	


}
