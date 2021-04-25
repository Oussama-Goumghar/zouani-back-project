package ma.learn.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.EtatInscription;




public interface EtatInscriptionDao  extends JpaRepository<EtatInscription,Long> {
	
	 int deleteByref(String ref);
	 EtatInscription findByref(String ref);
}
