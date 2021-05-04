package ma.learn.quiz.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Centre;
import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.dao.ParcoursDao;

@Service
public class ParcoursService {
	  
    @Autowired
    private ParcoursDao parcoursDao;
    @Autowired
    private CoursService coursService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private CentreService centreService;
    

	public Parcours findByCode(String code) {
		return parcoursDao.findByCode(code);
	}
	

	public List<Parcours> findByLibelle(String libelle) {
		return parcoursDao.findByLibelle(libelle);
	}


	@Transactional
	public int deleteByCode(String code) {
		
		int deleteBySectionCode=sectionService.deleteByCoursCode(code);
		int deleteByCoursCode=coursService.deleteByParcoursCode(code);
		int deleteByCode=parcoursDao.deleteByCode(code);
		return deleteBySectionCode+deleteByCoursCode+deleteByCode;
	}

	public void save(Parcours parcours) {
		
		create(parcours);
			for(int i=0;i<parcours.getNombreCours();i++) {
				Cours cours= new Cours();
				cours.setParcours(parcours);
				coursService.create(cours);
			}
		
		
	}

	 public int create(Parcours  parcours ) {
		 Centre centre=centreService.findByRef(parcours.getCentre().getRef());
			parcours.setCentre(centre);
			if(centre == null) {
				return -1;
			} else {
		 parcoursDao.save(parcours);}
			return 1;
	 }

	public List<Parcours> findByCentreRef(String ref) {
		return parcoursDao.findByCentreRef(ref);
	}

	public int deleteByCentreRef(String Ref) {
		return parcoursDao.deleteByCentreRef(Ref);
	}

	public List<Parcours> findAll() {
		return parcoursDao.findAll();
	}

	public void delete(Parcours entity) {
		parcoursDao.delete(entity);
	}

	public void update(Parcours parcours) {
		parcours.setCentre(parcours.getCentre());
		parcours.setLibelle(parcours.getLibelle());
		parcours.setDateCreation(parcours.getDateCreation());
		parcours.setDescription(parcours.getDescription());
		parcours.setDatePublication(parcours.getDatePublication());
		parcours.setCourses(parcours.getCourses());
		parcoursDao.save(parcours);
		
	}
	
   
}
