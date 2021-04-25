package ma.learn.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.SuperCategorieSection;
@Repository
public interface SuperCategorieSectionDao extends JpaRepository<SuperCategorieSection,Long> {
	SuperCategorieSection findByRef(String ref); 
    int deleteByRef(String ref);
}
