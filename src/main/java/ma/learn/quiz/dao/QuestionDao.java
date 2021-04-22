package ma.learn.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.learn.quiz.bean.Question;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
    Question findByRef(String ref);
    Question findByNumero(Long numero);
    List<Question> findByQuizRef(String ref);
    int deleteByQuizRef(String ref);
    int deleteByRef(String ref);
    int deleteByNumero(Long numero);
}