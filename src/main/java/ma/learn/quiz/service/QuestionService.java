package ma.learn.quiz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Question;
import ma.learn.quiz.bean.Quiz;
import ma.learn.quiz.bean.TypeDeQuestion;
import ma.learn.quiz.dao.QuestionDao;

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
    @Autowired
    private ReponseService reponseService;
    @Autowired
    private TypeDeQuestionService typeDeQuestionService;

    public void update(Question question){
        questionDao.save(question);
    }

    public Question findByRef(String ref) {
        return questionDao.findByRef(ref);
    }


    @Transactional
    public int deleteByRef(String ref) {
        int question =  questionDao.deleteByRef(ref);
        int reponse = reponseService.deleteByQuestionRef(ref);
        return question+reponse;
    }


    public List<Question> findAll() {
        return questionDao.findAll();
    }

    public int save(Question question) {
        if (findByRef(question.getRef()) != null) {
            return -1;
        }
        Quiz quiz=quizService.findByRef(question.getQuiz().getRef());
        TypeDeQuestion typeDeQuestion = typeDeQuestionService.findByRef(question.getTypeDeQuestion().getRef());
        question.setQuiz(quiz);
        question.setTypeDeQuestion(typeDeQuestion);
       if(quiz==null){
          return -2;
       }
       else if(typeDeQuestion==null)
       {
    	   return -3;
       }
       else{
           quizService.update(quiz);
           typeDeQuestionService.update(typeDeQuestion);
           questionDao.save(question);
           return 1;
       }
}
    
    
public Question findByNumero(Long numero) {
		return questionDao.findByNumero(numero);
	}

@Transactional
    public int deleteByQuizRef(String ref) {
        return questionDao.deleteByQuizRef(ref);
    }
}