package ma.learn.quiz.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.CategorieSection;
import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.Section;
import ma.learn.quiz.bean.SuperCategorieSection;
import ma.learn.quiz.dao.CategorieSectionDao;

@Service
public class CategorieSectionService {
	
	 @Autowired
	    private SectionService sectionService;
    @Autowired
    private CategorieSectionDao categorieSectionDao;
    @Autowired
    private SuperCategorieSectionService superCategorieSectionService;

    public int save(CategorieSection categorieSection) {
        if (findByRef(categorieSection.getRef()) != null) {
            return -1;
        }
        SuperCategorieSection superCategorieSection = superCategorieSectionService.findByRef(categorieSection.getSuperCategorieSection().getRef());
        categorieSection.setSuperCategorieSection(superCategorieSection);
	       if(superCategorieSection==null) return -2;
        else {
        	superCategorieSectionService.save(superCategorieSection);
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
    	int R1=sectionService.deleteByCategorieSectionRef(ref);
		int rsultat1=categorieSectionDao.deleteByRef(ref);
		return R1+rsultat1;
	}

	public List<Cours> findBySuperCategorieSectionRef(String ref) {
		return categorieSectionDao.findBySuperCategorieSectionRef(ref);
	}
	 @Transactional
	public int deleteBySuperCategorieSectionRef(String ref) {
		return categorieSectionDao.deleteBySuperCategorieSectionRef(ref);
	}

    
}
