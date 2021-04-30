package ma.learn.quiz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Parcours;

@Repository
public interface ParcoursDao extends JpaRepository<Parcours,Long> {

    Parcours findByRef(String ref);
    int deleteByRef(String ref);
    List<Parcours> findByLibelle(String libelle);

    List<Parcours> findByCentreRef(String ref);
    int deleteByCentreRef(String Ref);

 


}
