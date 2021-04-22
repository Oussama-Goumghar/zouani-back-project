package ma.learn.quiz.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Parcours;

@Repository
public interface ParcoursDao extends JpaRepository<Parcours,Long> {

    Parcours findByCode(String code);
    int deleteByCode(String code);

   



}
