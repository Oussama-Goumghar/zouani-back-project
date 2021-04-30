package ma.learn.quiz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.CategorieSection;
import ma.learn.quiz.bean.Cours;

@Repository
public interface CategorieSectionDao extends JpaRepository<CategorieSection,Long> {

	CategorieSection findByRef(String ref); 
	List<CategorieSection> findByLibelle(String libelle);
     int deleteByRef(String ref);
     List<Cours> findBySuperCategorieSectionRef(String ref); 
     int deleteBySuperCategorieSectionRef(String ref);
}



