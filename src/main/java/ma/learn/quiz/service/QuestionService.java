package ma.learn.quiz.service;

import ma.learn.quiz.bean.Question;
import ma.learn.quiz.bean.Quiz;
import ma.learn.quiz.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionService {

    public List<Question> findByQuizRef(String ref) {
        return questionDao.findByQuizRef(ref);
    }

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private QuizService quizService;

    public void update(Question question){
        questionDao.save(question);
    }

    public Question findByRef(String ref) {
        return questionDao.findByRef(ref);
    }


    @Transactional
    public int deleteByRef(String ref) {
        return questionDao.deleteByRef(ref);
    }


    public List<Question> findAll() {
        return questionDao.findAll();
    }

    public int save(Question question) {
        if (findByRef(question.getRef()) != null) {
            return -1;
        }
        Quiz quiz=quizService.findByRef(question.getQuiz().getRef());
        question.setQuiz(quiz);
       if(quiz==null){
          return -2;
       }else{
           quizService.update(quiz);
           questionDao.save(question);
           return 1;

       }


}
@Transactional
    public int deleteByQuizRef(String ref) {
        return questionDao.deleteByQuizRef(ref);
    }
}