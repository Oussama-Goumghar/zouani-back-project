package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Etudiant;



public interface EtudiantDao  extends JpaRepository<Etudiant,Long>  {
	 Etudiant findByref(String ref);
	    Etudiant findBynom(String nom);
	    int deleteByref(String ref);
	    int deleteBynom(String nom);
	    List<Etudiant> findByParcoursRef(String ref);


}
