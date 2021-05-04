package ma.learn.quiz.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.CategorieSection;
import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.Section;
import ma.learn.quiz.dao.CoursDao;

@Service
public class CoursService {
	int i;
	@Autowired
	public CategorieSectionService categorieSectionService;
    @Autowired
    private CoursDao coursDao ;
    @Autowired
	public SectionService sectionService;
    @Autowired
	public ParcoursService parcoursService;
    
    public List<Cours> findByLibelle(String libelle) {
		return coursDao.findByLibelle(libelle);
	}
	public List<Cours> findByParcoursCode(String code) {
		return coursDao.findByParcoursCode(code);
	}
	public Cours findByCode(String code) {
		return coursDao.findByCode(code);
	}
    @Transactional
	public int deleteByCode(String code) {
    	
		int deleteBySectionCode=sectionService.deleteByCoursCode(code);
		int deleteByCode=coursDao.deleteByCode(code);
		return deleteBySectionCode+deleteByCode;
	}
    public int init (Cours cours) {
		List<CategorieSection> categorieSectionList = categorieSectionService.findAll();
		for(CategorieSection categorieSection: categorieSectionList) {
			Section section = new Section();
			section.setCours(cours);
			section.setCategorieSection(categorieSection);
			sectionService.save(section);
		}
		return 1;
	}
    public void create(Cours cours) {
    	coursDao.save(cours);
    }
	public List<Cours> findAll() {
		return coursDao.findAll();
	}
	@Transactional
	public void delete(Cours entity) {
		coursDao.delete(entity);
	}
	
	@Transactional
	public int deleteByParcoursCode(String code) {
		return coursDao.deleteByParcoursCode(code);
	}
	public void update(Cours cours) {
		cours.setParcours(cours.getParcours());
		cours.setLibelle(cours.getLibelle());
		cours.setSections(cours.getSections());
		cours.setDescription(cours.getDescription());
		cours.setNumeroOrder(cours.getNumeroOrder());
		
		coursDao.save(cours);
		
	}
	public List<Cours> findCoursByParcours(Parcours parcours) {
		return coursDao.findCoursByParcours(parcours);
	}
	


}
