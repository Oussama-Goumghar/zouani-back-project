package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.CoursItem;
import ma.learn.quiz.bean.ParcoursItem;

@Repository
public interface CoursItemDao extends JpaRepository<CoursItem,Long> {

	List<CoursItem> findByCoursCode(String code);
	 int deleteByCoursCode(String code);
}
