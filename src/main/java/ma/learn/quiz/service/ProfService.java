package ma.learn.quiz.service;

import ma.learn.quiz.bean.Prof;
import ma.learn.quiz.bean.SessionCours;
import ma.learn.quiz.dao.ProfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfService {
    public Prof findByNumero(String ref) {
        return profDao.findByNumero(ref);
    }

    public int deleteByNumero(String ref) {
        return profDao.deleteByNumero(ref);
    }

    public List<Prof> findAll() {
        return profDao.findAll();
    }
    public int save(Prof prof){
        this.profDao.save(prof);
        return 1;
    }

    @Autowired
    private ProfDao profDao;
}
