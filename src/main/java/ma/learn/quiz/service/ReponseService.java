package ma.learn.quiz.service;

import ma.learn.quiz.bean.Question;

import ma.learn.quiz.bean.Reponse;
import ma.learn.quiz.dao.QuestionDao;
import ma.learn.quiz.dao.ReponseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReponseService {

    public List<Reponse> findByQuestionRef(String ref) {
        return reponseDao.findByQuestionRef(ref);
    }

    @Autowired
    private ReponseDao reponseDao;
    @Autowired
    private QuestionService questionService;

    public Reponse findByRef(String ref) {
        return reponseDao.findByRef(ref);
    }


    @Transactional
    public int deleteByRef(String ref) {
        return reponseDao.deleteByRef(ref);
    }


    public List<Reponse> findAll() {
        return reponseDao.findAll();
    }

    public int save(Reponse reponse) {
        if (findByRef(reponse.getRef()) != null) {
            return -1;
        }
        Question question = questionService.findByRef(reponse.getQuestion().getRef());
        reponse.setQuestion(question);
        if (question == null) {
            return -2;
        } else {
            questionService.update(question);
            reponseDao.save(reponse);
            return 1;

        }


    }

    @Transactional
    public int deleteByQuestionRef(String ref) {
        return reponseDao.deleteByQuestionRef(ref);
    }
}