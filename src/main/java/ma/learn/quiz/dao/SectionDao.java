package ma.learn.quiz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Section;

@Repository
public interface SectionDao extends JpaRepository<Section,Long>{
	
	 Section findByCode(String code); 
     int deleteByCode(String code);
     List<Section> findByCoursCode(String code); 
     int deleteByCoursCode(String code);
	}
 


