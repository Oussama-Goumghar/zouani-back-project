package ma.learn.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.FaqType;

public interface FaqTypeDao extends JpaRepository<FaqType, Long>{
	
	FaqType findByRef(String ref);
	int deleteByRef(String ref);

}
