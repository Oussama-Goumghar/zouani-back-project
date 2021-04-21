package ma.learn.quiz.dao;

import ma.learn.quiz.bean.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
    Question findByRef(String ref);
    List<Question> findByQuizRef(String ref);
    int deleteByQuizRef(String ref);
    int deleteByRef(String ref);
}