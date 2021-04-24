package ma.learn.quiz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Section;

@Repository
public interface SectionDao extends JpaRepository<Section,Long>{
	
	 Section findByRef(String ref); 
     int deleteByRef(String ref);
     List<Section> findByCoursRef(String ref); 
     int deleteByCoursRef(String ref);
     List<Section> findByCategorieSectionRef(String ref); 
     int deleteByCategorieSectionRef(String ref);
	}
 


