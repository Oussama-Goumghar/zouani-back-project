package ma.learn.quiz.service;


import java.util.List;
import java.util.Optional;

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
    private CoursService coursService ;
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
    public int deleteCoursById(Long id) {
    	int deleteBySectionCode=sectionService.deleteByCoursId(id);
		int deleteByCode=coursDao.deleteCoursById(id);
		return deleteBySectionCode+deleteByCode;
	}
	
	
    
    public int deleteByParcoursId(Long id) {
		return coursDao.deleteByParcoursId(id);
	}
	public int init (Long id) {
    	Cours cours=coursService.findCoursById(id);
		List<CategorieSection> categorieSections = categorieSectionService.findAll();
		for (CategorieSection categorieSection : categorieSections) {
            Section section = new Section();
            section.setCategorieSection(categorieSection);
            section.setLibelle(categorieSection.getCode());
            section.setCours(cours);  
			sectionService.create(section);
			System.out.println("saved");
			}
		return 2;
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
		cours.setDescription(cours.getDescription());
		cours.setImage(cours.getImage());
		cours.setSections(cours.getSections());
		cours.setNumeroOrder(cours.getNumeroOrder());
		cours.setNombreLinkEnCours(cours.getNombreLinkEnCours());
		cours.setNombreLinkFinalise(cours.getNombreLinkFinalise());
		cours.setNombreSectionEnCours(cours.getNombreSectionEnCours());
		cours.setNombreSectionFinalise(cours.getNombreSectionFinalise());
		coursDao.save(cours);
		
	}
	public List<Cours> findCoursByParcours(Parcours parcours) {
		return coursDao.findCoursByParcours(parcours);
	}
	
	public Cours findCoursById(Long id) {
		return coursDao.findCoursById(id);
	}
	


}
