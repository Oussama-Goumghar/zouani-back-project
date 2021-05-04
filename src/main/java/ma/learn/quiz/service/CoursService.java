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
	public List<Cours> findByParcoursRef(String ref) {
		return coursDao.findByParcoursRef(ref);
	}
	public Cours findByRef(String ref) {
		return coursDao.findByRef(ref);
	}
    @Transactional
	public int deleteByRef(String ref) {
    	
		int deleteBySectionRef=sectionService.deleteByCoursRef(ref);
		int deleteByRef=coursDao.deleteByRef(ref);
		return deleteBySectionRef+deleteByRef;
	}
    public int init (Cours cours) {
		List<CategorieSection> categorieSectionList = categorieSectionService.findAll();
		for(CategorieSection categorieSection: categorieSectionList) {
			Section section = new Section();
			section.setCours(cours);
			section.setRef("sect"+categorieSection.getRef());
			section.setCategorieSection(categorieSection);
			sectionService.save(section);
		}
		return 1;
	}
	public void save(Parcours parcours, List<Cours> courss) {
		for (Cours cours:courss) {
			for(i=0;i<parcours.getNombreCours();i++) {
				cours.setRef("ref"+Integer.toString(i));
				coursDao.save(cours);
			}
		}
		
	}
	public List<Cours> findAll() {
		return coursDao.findAll();
	}
	@Transactional
	public void delete(Cours entity) {
		coursDao.delete(entity);
	}
	
	@Transactional
	public int deleteByParcoursRef(String ref) {
		return coursDao.deleteByParcoursRef(ref);
	}
	public void update(Cours cours) {
		cours.setParcours(cours.getParcours());
		cours.setLibelle(cours.getLibelle());
		cours.setSections(cours.getSections());
		cours.setDescription(cours.getDescription());
		cours.setNumeroOrder(cours.getNumeroOrder());
		cours.setNombreContenuEnCours(cours.getNombreContenuEnCours());
		cours.setNombreContenuFinalise(cours.getNombreContenuFinalise());
		cours.setNombreLienEnCours(cours.getNombreLienEnCours());
		cours.setNombreLienFinalise(cours.getNombreLienFinalise());
		coursDao.save(cours);
		
	}
	public List<Cours> findCoursByParcours(Parcours parcours) {
		return coursDao.findCoursByParcours(parcours);
	}
	


}
