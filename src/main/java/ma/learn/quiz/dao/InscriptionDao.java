package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Inscription;

public interface InscriptionDao extends JpaRepository<Inscription,Long>  {
	Inscription findByNumeroInscription(String numeroInscription);
	
	int deleteByNumeroInscription(String numeroInscription);
	
	 List<Inscription> findByParcoursRef(String ref);
	 
	 Inscription findByEtudiantRef(String ref);
	 Inscription findByEtatInscriptionRef(String ref);
}
