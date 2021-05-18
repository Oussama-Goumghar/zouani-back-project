package ma.learn.quiz.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
	
	 

	public int deleteByCours(Cours cours) {
		return sectionDao.deleteByCours(cours);
	}

	


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
	public int deleteSectionById(List<Section> sections) {
		int res=0;
        for (int i = 0; i < sections.size(); i++) {
            res+=deleteSectionById(sections.get(i).getId());
        }
        return res;
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

  
 public int create(Section section) {		
			sectionDao.save(section);
			
			return  1;
	}
   
	
	
 public int save(Section section) {	
	 Cours cours = coursService.findCoursById(section.getCours().getId());
	 if(cours==null) return-1;
	 CategorieSection categorieSection = categorieSectionService.findByCode(section.getCategorieSection().getCode());
	 if(categorieSection==null) return-2;
	 else {
	 section.setCategorieSection(categorieSection);
	 section.setCours(cours);
		sectionDao.save(section);
		
		return  1;}
}





public List<Section> findAll() {
		return sectionDao.findAll();
	}

public Section update(Section section){

	Optional<Section> sections= sectionDao.findById(section.getId());
	Section LoadedSection=sections.get();
	Cours cours=coursService.findCoursById(section.getCours().getId());
	LoadedSection.setCours(cours);
	CategorieSection categorieSection=categorieSectionService.findCategorieSectionById(section.getCategorieSection().getId());
	LoadedSection.setCategorieSection(categorieSection);
	LoadedSection.setLibelle(section.getLibelle());
	LoadedSection.setContenu(section.getContenu());
	LoadedSection.setIndicationProf(section.getIndicationProf());
	LoadedSection.setQuestions(section.getQuestions());
	LoadedSection.setNumeroOrder(section.getNumeroOrder());
	LoadedSection.setQuestions(section.getQuestions());
	LoadedSection.setUrlVideo(section.getUrlVideo());
	LoadedSection.setUrlImage(section.getUrlImage());
	LoadedSection.setUrlImage2(section.getUrlImage2());
	LoadedSection.setUrlImage3(section.getUrlImage3());
	LoadedSection.setCode(section.getCode());
	if(section.getUrlImage() != null || section.getUrlVideo() != null) {
		LoadedSection.setUrl(1);
	}
	if(section.getContenu() != null) {
		LoadedSection.setContent(1);
	}coursService.update(section.getCours());
		return sectionDao.save(LoadedSection);
		
   }




public int deleteByCoursId(Long id) {
	return sectionDao.deleteByCoursId(id);
}



@Transactional
public int deleteSectionById(Long id) {
	return sectionDao.deleteSectionById(id);
}




public Section findSectionById(Long id) {
	return sectionDao.findSectionById(id);
}




public Section findSectionByCours(Cours cours) {
	return sectionDao.findSectionByCours(cours);
}




public Section findSectionByCoursAndCategorieSection(Cours cours, CategorieSection categorieSection) {
	return sectionDao.findSectionByCoursAndCategorieSection(cours, categorieSection);
}







  
	
   
   
}

	

