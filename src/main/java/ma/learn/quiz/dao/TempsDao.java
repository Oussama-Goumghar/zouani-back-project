package ma.learn.quiz.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Temps;




public interface TempsDao   extends JpaRepository<Temps,Long>{
	Temps findHoraireByref(String ref);

}
