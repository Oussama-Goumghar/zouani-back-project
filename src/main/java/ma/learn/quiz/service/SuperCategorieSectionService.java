package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.CategorieSection;
import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.SuperCategorieSection;
import ma.learn.quiz.dao.SuperCategorieSectionDao;
@Service
public class SuperCategorieSectionService {
@Autowired
private SuperCategorieSectionDao superCategorieSectionDao;
@Autowired
private CategorieSectionService categorieSectionService;
@Autowired
private SectionService sectionService;


public List<SuperCategorieSection> findByLibelle(String libelle) {
	return superCategorieSectionDao.findByLibelle(libelle);
}
public List<Cours> findBySuperCategorieSectionRef(String ref) {
	return categorieSectionService.findBySuperCategorieSectionRef(ref);
}
public SuperCategorieSection findByRef(String ref) {
	return superCategorieSectionDao.findByRef(ref);
}
@Transactional
public int deleteByRef(String ref) {
	int r1=sectionService.deleteByCategorieSectionRef(ref);
	int r2=categorieSectionService.deleteBySuperCategorieSectionRef(ref);
	int r3= superCategorieSectionDao.deleteByRef(ref);
	return r1+r2+r3;
}

public int save(SuperCategorieSection superCategorieSection) {
	if (findByRef(superCategorieSection.getRef()) != null) {
        return -1;
    }
	else {
	superCategorieSectionDao.save(superCategorieSection);
	return 1;
	}
}

public List<SuperCategorieSection> findAll() {
	return superCategorieSectionDao.findAll();
}
public void update(SuperCategorieSection superCategorieSection) {
	superCategorieSectionDao.save(superCategorieSection);
}
public void deleteAll() {
	superCategorieSectionDao.deleteAll();
}

}
