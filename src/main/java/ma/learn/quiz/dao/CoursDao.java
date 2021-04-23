package ma.learn.quiz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Cours;

@Repository
public interface CoursDao extends JpaRepository<Cours, Long> {

     Cours findByCode(String code);
     int deleteByCode(String code);
     List<Cours> findByParcoursCode(String code); 
     int deleteByParcoursCode(String code);

     

}
