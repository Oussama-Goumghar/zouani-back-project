package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Inscription;


public interface InscriptionDao extends JpaRepository<Inscription,Long>  {
	Inscription findBynumeroInscription(String numeroInscription);
	Inscription findByref(String ref);
	int deleteBynumeroInscription(String numeroInscription);
	 int deleteByref(String ref);
	 List<Inscription> findByParcoursRef(String ref);

}
