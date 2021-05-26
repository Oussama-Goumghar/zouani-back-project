package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.FaqProf;

public interface FaqProfDao extends JpaRepository<FaqProf, Long>{
	
	FaqProf findByRef(String ref);
	int deleteByRef(String ref);
	List<FaqProf> findByFaqTypeRef(String ref);
	int deleteByFaqTypeRef(String ref);
	List<FaqProf> findByProfRef(String ref);
	int deleteByProfRef(String ref);
}
