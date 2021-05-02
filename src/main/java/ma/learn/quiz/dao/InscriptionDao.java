package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Inscription;

public interface InscriptionDao extends JpaRepository<Inscription,Long>  {
	Inscription findByNumeroInscription(int numeroInscription);
	
	int deleteByNumeroInscription(int numeroInscription);
	
	int deleteByEtudiantRef(String ref);
	int deleteByEtatInscriptionRef(String ref);
	 
	 Inscription findByEtudiantRef(String ref);
	 Inscription findByEtatInscriptionRef(String ref);
}
