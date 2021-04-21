package ma.learn.quiz.dao;

import ma.learn.quiz.bean.Question;
import ma.learn.quiz.bean.TypeDeQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDeQuestionDao extends JpaRepository<TypeDeQuestion, Long> {
    TypeDeQuestion findByRef(String ref);
    int deleteByRef(String ref);
}