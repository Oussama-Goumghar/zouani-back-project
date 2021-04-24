package ma.learn.quiz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.CategorieSection;

@Repository
public interface CategorieSectionDao extends JpaRepository<CategorieSection,Long> {

	CategorieSection findByRef(String ref); 
     int deleteByRef(String ref);
     
}



