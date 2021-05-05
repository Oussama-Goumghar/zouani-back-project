package ma.learn.quiz.service;

import ma.learn.quiz.bean.SessionCours;
import ma.learn.quiz.dao.SessionCoursDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SessionCoursService {
    public SessionCours findByNumero(String numero) {
        return sessionCoursDao.findByNumero(numero);
    }
@Transactional
    public int deleteByNumero(String numero) {
        return sessionCoursDao.deleteByNumero(numero);
    }

    public List<SessionCours> findAll() {
        return sessionCoursDao.findAll();
    }
    public int save(SessionCours sessionCours){
        this.sessionCoursDao.save(sessionCours);
        return 1;
    }
@Autowired
    private SessionCoursDao sessionCoursDao;
}
