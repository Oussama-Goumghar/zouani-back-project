package ma.learn.quiz.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.Section;
import ma.learn.quiz.dao.SectionDao;

@Service
public class SectionService {

	 @Autowired
		public ParcoursService parcoursService;
	@Autowired
	public SectionDao sectionDao;
	@Autowired
	public CoursService coursService;
	
	public List<Section> findByCoursCode(String code) {
		return sectionDao.findByCoursCode(code);
	}

	@Transactional
	public int deleteByCoursCode(String code) {
		return sectionDao.deleteByCoursCode(code);
	}

	@Autowired
	public CategorieSectionService categorieSectionService;
	

   public Section findByCode(String code) {
		return sectionDao.findByCode(code);
	}

   @Transactional
	public int deleteByCode(String code) {
		int rslt2 =categorieSectionService.deleteBySectionCode(code);
		int rslt1 = sectionDao.deleteByCode(code);
		 return  rslt2+rslt1;
	}

	 public int save(Section section) {
		if (findByCode(section.getCode())!=null) {
			return -1;
		}
		Cours cours = coursService.findByCode(section.getCours().getCode());
	       section.setCours(cours);
	       if(cours==null) return -2;
	       Parcours parcours = parcoursService.findByCode(cours.getParcours().getCode());
	       cours.setParcours(parcours);
	       if(parcours==null) return -3;
		else {
			parcoursService.update(parcours);
			coursService.update(cours);
			sectionDao.save(section);
			return  1;

		}
	}
	
@Transactional
public List<Section> findAll() {
		return sectionDao.findAll();
	}

public void update(Section section){
		sectionDao.save(section);
   }


  
	
   
   
}

	

