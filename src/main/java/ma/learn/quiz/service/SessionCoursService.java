package ma.learn.quiz.service;

import ma.learn.quiz.bean.SessionCours;
import ma.learn.quiz.dao.SessionCoursDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class SessionCoursService {
    @Autowired
    private SessionCoursDao sessionCoursDao;


    public SessionCours findByReference(String reference) {
        return sessionCoursDao.findByReference(reference);
    }


    public SessionCours save(SessionCours sessionCours) {
        if (findByReference(sessionCours.getReference()) == null)
            sessionCoursDao.save(sessionCours);
        return sessionCours;
    }


    public SessionCours update(SessionCours sessionCours) {
        return sessionCoursDao.save(sessionCours);
    }


    public List<SessionCours> findAll() {
        return sessionCoursDao.findAll();
    }


    @Transactional
    public int deleteByReference(String reference) {
        return sessionCoursDao.deleteByReference(reference);
    }


    @Transactional
    public int deleteByReference(List<SessionCours> sessionCourss) {
        int res = 0;
        for (int i = 0; i < sessionCourss.size(); i++) {
            res += deleteByReference(sessionCourss.get(i).getReference());
        }
        return res;
    }
}
