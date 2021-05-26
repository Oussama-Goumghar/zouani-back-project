package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Faq;

public interface FaqDao extends JpaRepository<Faq, Long>{
	
	Faq findByRef(String ref);
	int deleteByRef(String ref);
	List<Faq> findByFaqTypeRef(String ref);
	int deleteByFaqTypeRef(String ref);
}
