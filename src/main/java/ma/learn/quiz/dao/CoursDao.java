package ma.learn.quiz.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Cours;

@Repository
public interface CoursDao extends JpaRepository<Cours, Long> {

     Cours findByCode(String code);
     int deleteByCode(String code);
    

   


}
