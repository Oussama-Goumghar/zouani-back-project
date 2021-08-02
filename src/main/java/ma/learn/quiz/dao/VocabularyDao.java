package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Vocabulary;
import ma.learn.quiz.bean.VocabularyQuiz;

public interface VocabularyDao extends JpaRepository<Vocabulary, Long>{
	Vocabulary findByRef(String ref);
	int deleteByRef(String ref);
	int deleteBySectionId(Long id);
	List<Vocabulary> findByVocabularyQuizRef(String ref);
	List<Vocabulary> findBySectionId(Long id);
	List<Vocabulary> findByNumeroAndSectionId(Long numero,Long id);
	Vocabulary findByNumero(Long numero);
}
