package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Etudiant;



@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
	Etudiant findByRef(String ref);
	int deleteByRef(String ref);
	
	    List<Etudiant> findByParcoursCode(String code);

}