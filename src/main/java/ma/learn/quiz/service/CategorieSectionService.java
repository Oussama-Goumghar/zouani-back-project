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
        if (findByRef(categorieSection.getRef()) != null) {
            return -1;
        }
       Section section = sectionService.findByRef(categorieSection.getSection().getRef());
       categorieSection.setSection(section);
       if(section==null) return -2;

       Cours cours = coursService.findByRef(section.getCours().getRef());
       section.setCours(cours);
       if(cours==null) return -3;
       Parcours parcours = parcoursService.findByRef(cours.getParcours().getRef());
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
    public CategorieSection findByRef(String ref) {
        return categorieSectionDao.findByRef(ref);
    }

    public List<CategorieSection> findAll() {
        return categorieSectionDao.findAll();
    }
    @Transactional
	public int deleteByRef(String ref) {
		int rsultat1=categorieSectionDao.deleteByRef(ref);
		return rsultat1;
	}

	public List<CategorieSection> findBySectionRef(String ref) {
		return categorieSectionDao.findBySectionRef(ref);
	}

	@Transactional
	public int deleteBySectionRef(String ref) {
		return categorieSectionDao.deleteBySectionRef(ref);
	}

    

    

   

	

    
}
