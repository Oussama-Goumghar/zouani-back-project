package ma.learn.quiz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Cours;

@Repository
public interface CoursDao extends JpaRepository<Cours, Long> {

     Cours findByRef(String ref);
     int deleteByRef(String ref);
     List<Cours> findByParcoursRef(String ref); 
     int deleteByParcoursRef(String ref);

     

}
