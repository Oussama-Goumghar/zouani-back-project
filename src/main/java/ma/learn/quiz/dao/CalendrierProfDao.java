package ma.learn.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.CalendrierProf;

public interface CalendrierProfDao extends JpaRepository<CalendrierProf, Long> {

	CalendrierProf findByRef(String ref);
	int deleteByRef(String ref);
	int deleteCalendrierProfById(Long id);
	
}
