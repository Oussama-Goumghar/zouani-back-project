package ma.learn.quiz.dao;

import ma.learn.quiz.bean.Question;
import ma.learn.quiz.bean.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseDao extends JpaRepository<Reponse, Long> {
    Reponse findByRef(String ref);

    List<Reponse> findByQuestionRef(String ref);

    int deleteByQuestionRef(String ref);

    int deleteByRef(String ref);
}