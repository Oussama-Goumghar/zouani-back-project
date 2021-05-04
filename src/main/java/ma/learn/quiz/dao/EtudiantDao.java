package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Etudiant;



public interface EtudiantDao  extends JpaRepository<Etudiant,Long>  {
	 Etudiant findByRef(String ref);
	    Etudiant findByNom(String nom);
	    int deleteByRef(String ref);
	    int deleteByNom(String nom);
	    List<Etudiant> findByParcoursCode(String code);
	    int deleteByParcoursCode(String code);

}
