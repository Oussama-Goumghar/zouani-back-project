package ma.learn.quiz.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.learn.quiz.bean.RecommendTeacher;

public interface RecommendTeacherDao extends JpaRepository<RecommendTeacher,Long>{
	RecommendTeacher findByRef(String ref);
	Optional<RecommendTeacher> findById(Long id);
	RecommendTeacher findByProfNom(String nom);
	
	

}
