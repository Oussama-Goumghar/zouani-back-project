package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.QuizEtudiant;



@Repository
public interface QuizEtudiantDao extends JpaRepository<QuizEtudiant, Long> {
	QuizEtudiant findByRef(String ref);
	int deleteByRef(String Ref);
	List<QuizEtudiant> findByQuizRef(String ref);
	List<QuizEtudiant> findByEtudiantRef(String ref);
	int deleteByQuizRef(String ref);
}