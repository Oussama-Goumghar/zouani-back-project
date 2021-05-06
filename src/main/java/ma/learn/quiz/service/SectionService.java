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




	public List<Section> findByLibelle(String libelle) {
		return sectionDao.findByLibelle(libelle);
	}




	public List<Section> findByCategorieSectionLibelle(String libelle) {
		return sectionDao.findByCategorieSectionLibelle(libelle);
	}




	@Transactional
	public int deleteByCoursCode(String code) {
		return sectionDao.deleteByCoursCode(code);
	}

	
	

   public List<Section> findByCoursCode(String code) {
		return sectionDao.findByCoursCode(code);
	}




public List<Section> findByCoursId(Long id) {
	return sectionDao.findByCoursId(id);
}




public List<Section> findByCategorieSectionCode(String code) {
		return sectionDao.findByCategorieSectionCode(code);
	}

	public int deleteByCategorieSectionCode(String code) {
		return sectionDao.deleteByCategorieSectionCode(code);
	}

public Section findByCode(String code) {
		return sectionDao.findByCode(code);
	}

   @Transactional
	public int deleteByCode(String code) {	
		int rslt1 = sectionDao.deleteByCode(code);
		 return  rslt1;
	}
 public int save(Section section) {
	 
		if (findByCode(section.getCode())!=null) {
			return -1;
		}
		Cours cours = coursService.findByCode(section.getCours().getCode()); if(cours==null) return -2;
	    CategorieSection categorieSection=categorieSectionService.findByCode(section.getCategorieSection().getCode()); if(categorieSection==null) return -4;
		else {
			section.setCours(cours);
			section.setCategorieSection(categorieSection);
			sectionDao.save(section);
			
			return  1;

		}
	}
   
	
	

public List<Section> findAll() {
		return sectionDao.findAll();
	}

public void update(Section section){
	section.setCategorieSection(section.getCategorieSection());
	section.setLibelle(section.getLibelle());
	section.setContenu(section.getContenu());
	section.setIndicationProf(section.getIndicationProf());

	section.setQuestions(section.getQuestions());
	section.setCours(section.getCours());

		sectionDao.save(section);
   }


  
	
   
   
}

	

