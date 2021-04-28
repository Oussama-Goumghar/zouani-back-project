package ma.learn.quiz.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.CategorieSection;
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
	@Autowired
	public CategorieSectionService categorieSectionService;
	
	

	public List<Section> findByCours(Cours cours) {
		return sectionDao.findByCours(cours);
	}




	@Transactional
	public int deleteByCoursRef(String ref) {
		return sectionDao.deleteByCoursRef(ref);
	}

	
	

   public List<Section> findByCategorieSectionRef(String ref) {
		return sectionDao.findByCategorieSectionRef(ref);
	}

	public int deleteByCategorieSectionRef(String ref) {
		return sectionDao.deleteByCategorieSectionRef(ref);
	}

public Section findByRef(String ref) {
		return sectionDao.findByRef(ref);
	}

   @Transactional
	public int deleteByRef(String ref) {	
		int rslt1 = sectionDao.deleteByRef(ref);
		 return  rslt1;
	}

   public int save(Cours cours,List<Section> sections) {
		for(Section section : sections) {
			section.setCours(cours);
			sectionDao.save(section);
		}
			return  1;

		}
	
	public int save(CategorieSection categorieSection, List<Section> sections) {
	for(Section section : sections) {
		section.setCategorieSection(categorieSection);
		sectionDao.save(section);
	}
		return  1;

	
}

	 public int save(Section section) {
		if (findByRef(section.getRef())!=null) {
			return -1;
		}
		Cours cours = coursService.findByRef(section.getCours().getRef());
	       section.setCours(cours);
	       if(cours==null) return -2;
	       Parcours parcours = parcoursService.findByRef(cours.getParcours().getRef());
	       cours.setParcours(parcours);
	       if(parcours==null) return -3;
	       CategorieSection categorieSection=categorieSectionService.findByRef(section.getCategorieSection().getRef());
	       section.setCategorieSection(categorieSection);
	       if(categorieSection==null) return -4;
		else {
			sectionDao.save(section);
			
			return  1;

		}
	}
	

public List<Section> findAll() {
		return sectionDao.findAll();
	}

public void update(Section section){
		sectionDao.save(section);
   }


  
	
   
   
}

	

