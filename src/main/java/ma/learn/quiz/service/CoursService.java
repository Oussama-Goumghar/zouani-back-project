package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.CategorieSection;
import ma.learn.quiz.bean.Centre;
import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.Section;
import ma.learn.quiz.dao.CoursDao;

@Service
public class CoursService {

	@Autowired
	public CategorieSectionService categorieSectionService;
	@Autowired
	private CoursDao coursDao;
	@Autowired
	private CoursService coursService;
	@Autowired
	public SectionService sectionService;
	@Autowired
	public ParcoursService parcoursService;

	public List<Cours> findByLibelle(String libelle) {
		return coursDao.findByLibelle(libelle);
	}

	public List<Cours> findByParcoursId(Long id) {
		return coursDao.findByParcoursId(id);
	}
	@Transactional
	public int deleteCoursById(List<Cours> courss) {
		int res=0;
        for (int i = 0; i < courss.size(); i++) {
            res+=deleteCoursById(courss.get(i).getId());
        }
        return res;
	}
	@Transactional
	public int deleteCoursById(Long id) {
		int deleteBySectionCode = sectionService.deleteByCoursId(id);
		int deleteByCode = coursDao.deleteCoursById(id);
		return deleteBySectionCode + deleteByCode;
	}
	
	public int deleteByParcoursId(Long id) {
		return coursDao.deleteByParcoursId(id);
	}

	public int init(Long id) {
		Cours cours = coursService.findCoursById(id);
		List<Section> sectionCours = sectionService.findByCoursId(id);

		List<CategorieSection> categorieSections = categorieSectionService.findAll();
		for (CategorieSection categorieSection : categorieSections) {
			if (findByCategorieSection(categorieSection, sectionCours) == null) {
				Section section = new Section();
				section.setCategorieSection(categorieSection);
				section.setLibelle(categorieSection.getCode());
				section.setCours(cours);
				sectionService.create(section);
				System.out.println("saved");
			}
		}

		return 2;
	}

	private Section findByCategorieSection(CategorieSection categorieSection, List<Section> sectionCours) {
		if(sectionCours==null) return null;
		else {
			for (Section section : sectionCours) {
				if(section.getCategorieSection()!=null && section.getCategorieSection().getId()==categorieSection.getId()) {
					return section;
				}
			
			}
			return null;
		}
		
	}

	public int save(Cours cours) {
		Parcours parcours = parcoursService.findByCode(cours.getParcours().getCode());
		if (parcours == null)
			return -1;
		cours.setParcours(parcours);
		coursDao.save(cours);
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

	public Cours update(Cours cours) {
		List<Section> sections = sectionService.findByCours(cours);
		int nbFinalise = 0, nbEncours = 0, nbrLinkFinalise = 0, nbrLinkEncours = 0;
		for (Section section : sections) {
			if (section.getContenu() != null) {
				nbFinalise++;

			} else {
				nbEncours++;

			}
			if (section.getUrlImage() != null || section.getUrlVideo() != null) {
				nbrLinkFinalise++;

			} else {
				nbrLinkEncours++;
			}
		}
		 Parcours parcours=parcoursService.findParcoursById(cours.getParcours().getId());
		 cours.setParcours(parcours);
		cours.setLibelle(cours.getLibelle());
		cours.setDescription(cours.getDescription());
		cours.setImage(cours.getImage());
		cours.setSections(cours.getSections());
		cours.setNumeroOrder(cours.getNumeroOrder());
		cours.setNombreLinkEnCours(nbrLinkEncours);
		cours.setNombreLinkFinalise(nbrLinkFinalise);
		cours.setNombreSectionEnCours(nbEncours);
		cours.setNombreSectionFinalise(nbFinalise);
		return coursDao.save(cours);

	}

	public Cours findCoursById(Long id) {
		return coursDao.findCoursById(id);
	}

}
