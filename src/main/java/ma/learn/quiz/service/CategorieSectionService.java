package ma.learn.quiz.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.CategorieSection;
import ma.learn.quiz.bean.Section;
import ma.learn.quiz.dao.CategorieSectionDao;

@Service
public class CategorieSectionService {
	
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
        else {
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
    @Transactional
	public int deleteByCode(String code) {
		
		return categorieSectionDao.deleteByCode(code);
	}
	public List<CategorieSection> findBySectionCode(String code) {
		return categorieSectionDao.findBySectionCode(code);
	}
	@Transactional
	public int deleteBySectionCode(String code) {
		return categorieSectionDao.deleteBySectionCode(code);
	}

   

	

    
}
