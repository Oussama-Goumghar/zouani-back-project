package ma.learn.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Centre;





public interface CentreDao extends JpaRepository<Centre,Long> {
	 int deleteByref(String ref);
		Centre findByref(String ref);
		 
}
