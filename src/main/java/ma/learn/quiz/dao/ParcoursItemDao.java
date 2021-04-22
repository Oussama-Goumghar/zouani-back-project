package ma.learn.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.ParcoursItem;

@Repository
public interface ParcoursItemDao extends JpaRepository<ParcoursItem,Long> {

	 List<ParcoursItem> findByParcoursCode(String code);
	 int deleteByParcoursCode(String code);
}
