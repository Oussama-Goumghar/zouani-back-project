package ma.learn.quiz.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Centre;
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
    

	public Parcours findByRef(String ref) {
		return parcoursDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		
		int deleteBySectionRef=sectionService.deleteByCoursRef(ref);
		int deleteByCoursRef=coursService.deleteByParcoursRef(ref);
		int deleteByRef=parcoursDao.deleteByRef(ref);
		return deleteBySectionRef+deleteByCoursRef+deleteByRef;
	}

	 public int save(Parcours  parcours ) {
			if(findByRef(parcours.getRef())!=null) {
				return -1;
			}
			Centre centre=centreService.findByref(parcours.getCentre().getRef());
			parcours.setCentre(centre);
			if(centre==null) {
				return -3;
			}
			else {
				parcoursDao.save(parcours);
				return 1;
			}
				
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
		parcoursDao.save(parcours);
		
	}
   
}
