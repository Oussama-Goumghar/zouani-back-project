package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.ReponseEtudiant;



@Repository
public interface ReponseEtudiantDao extends JpaRepository<ReponseEtudiant, Long> {
	ReponseEtudiant findByRef(String ref);
	int deleteByRef(String Ref);
	List<ReponseEtudiant> findByQuestionRef(String ref);
	List<ReponseEtudiant> findByEtudiantRef(String ref);
	List<ReponseEtudiant> findByReponseRef(String ref);
	int deleteByQuestionRef(String ref);
	int deleteByEtudiantRef(String ref);
	int deleteByReponseRef(String ref);
}