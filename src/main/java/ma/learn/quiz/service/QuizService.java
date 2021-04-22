package ma.learn.quiz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Quiz;
import ma.learn.quiz.dao.QuizDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionService questionService ;

    public void update(Quiz quiz){
        quizDao.save(quiz);
    }

    public Quiz findByRef(String ref) {
        return quizDao.findByRef(ref);
    }


    @Transactional
    public int deleteByRef(String ref) {
       int a= questionService.deleteByQuizRef(ref);
        int b =quizDao.deleteByRef(ref);
        return a+b;
    }


    public List<Quiz> findAll() {
        return quizDao.findAll();
    }

    public int save(Quiz quiz) {
        if (findByRef(quiz.getRef()) != null) {
            return -1;
        } else {
            quizDao.save(quiz);
            return 1;
        }
    }

}
