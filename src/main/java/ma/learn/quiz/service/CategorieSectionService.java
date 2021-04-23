package ma.learn.quiz.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.CategorieSection;
import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.Section;
import ma.learn.quiz.dao.CategorieSectionDao;

@Service
public class CategorieSectionService {
	
	@Autowired
	public CoursService coursService;
	 @Autowired
		public ParcoursService parcoursService;
	 @Autowired
	    private SectionService sectionService;
    @Autowired
    private CategorieSectionDao categorieSectionDao;

    public int save(CategorieSection categorieSection) {
        if (findByCode(categorieSection.getCode()) != null) {
            return -1;
        }
       Section section = sectionService.findByCode(categorieSection.getSection().getCode());
       categorieSection.setSection(section);
       if(section==null) return -2;

       Cours cours = coursService.findByCode(section.getCours().getCode());
       section.setCours(cours);
       if(cours==null) return -3;
       Parcours parcours = parcoursService.findByCode(cours.getParcours().getCode());
       cours.setParcours(parcours);
       if(parcours==null) return -4;
        else {
        	parcoursService.update(parcours);
			coursService.update(cours);
        	sectionService.update(section);
            categorieSectionDao.save(categorieSection);
            return 1;
        }

    }
    
    public void update(CategorieSection categorieSection) {
    	categorieSectionDao.save(categorieSection);
    }
    public CategorieSection findByCode(String code) {
        return categorieSectionDao.findByCode(code);
    }

    public List<CategorieSection> findAll() {
        return categorieSectionDao.findAll();
    }

	public int deleteByCode(String code) {
		int rsultat1=categorieSectionDao.deleteByCode(code);
		return rsultat1;
	}

	public List<CategorieSection> findBySectionCode(String code) {
		return categorieSectionDao.findBySectionCode(code);
	}

	@Transactional
	public int deleteBySectionCode(String code) {
		return categorieSectionDao.deleteBySectionCode(code);
	}

    

    

   

	

    
}
