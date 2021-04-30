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
    private CoursDao coursDao ;
    @Autowired
	public SectionService sectionService;
    @Autowired
	public ParcoursService parcoursService;
    
    public List<Cours> findByLibelle(String libelle) {
		return coursDao.findByLibelle(libelle);
	}
	public List<Cours> findByParcoursRef(String ref) {
		return coursDao.findByParcoursRef(ref);
	}
	public Cours findByRef(String ref) {
		return coursDao.findByRef(ref);
	}
    @Transactional
	public int deleteByRef(String ref) {
    	
		int deleteBySectionRef=sectionService.deleteByCoursRef(ref);
		int deleteByRef=coursDao.deleteByRef(ref);
		return deleteBySectionRef+deleteByRef;
	}
	public int save(Cours cours) {
		if(findByRef(cours.getRef())!=null) {
			return -1;
		}
		Parcours parcours = parcoursService.findByRef(cours.getParcours().getRef());
	       
	       if(parcours==null) return -2;
		else {
			cours.setParcours(parcours);
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
	
	@Transactional
	public int deleteByParcoursRef(String ref) {
		return coursDao.deleteByParcoursRef(ref);
	}
	public void update(Cours cours) {
		coursDao.save(cours);
		
	}
	public List<Cours> findCoursByParcours(Parcours parcours) {
		return coursDao.findCoursByParcours(parcours);
	}
	


}
