package ma.learn.quiz.dao;

import ma.learn.quiz.bean.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfDao extends JpaRepository<Prof, Long> {
    Prof findByNumero(String ref);
    int deleteByNumero(String ref);
}