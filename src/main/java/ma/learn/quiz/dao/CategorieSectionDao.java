package ma.learn.quiz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.CategorieSection;

@Repository
public interface CategorieSectionDao extends JpaRepository<CategorieSection,Long> {

	CategorieSection findByCode(String code); 
     int deleteByCode(String code);
     List<CategorieSection> findBySectionCode(String code); 
     int deleteBySectionCode(String code); 
}



