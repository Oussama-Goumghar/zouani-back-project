package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Quiz;
import ma.learn.quiz.bean.QuizEtudiant;
import ma.learn.quiz.dao.QuizEtudiantDao;


@Service
public class QuizEtudiantService {

	@Autowired
	private QuizEtudiantDao quizEtudiantDao;
	public List<QuizEtudiant> findByResultat(String resultat) {
		return quizEtudiantDao.findByResultat(resultat);
	}

	@Autowired
	private QuizService quizService;
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private ReponseEtudiantService reponseEtudiantService;

	public QuizEtudiant findByRef(String ref) {
		return quizEtudiantDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String Ref) {
		int quizEtudiant = quizEtudiantDao.deleteByRef(Ref);
		int reponseEtudiant = reponseEtudiantService.deleteByRef(Ref);
		return quizEtudiant+reponseEtudiant;
	}

	public List<QuizEtudiant> findByQuizRef(String ref) {
		return quizEtudiantDao.findByQuizRef(ref);
	}



	@Transactional
	public int deleteByQuizRef(String ref) {
		return quizEtudiantDao.deleteByQuizRef(ref);
	}



	public int save(QuizEtudiant quizEtudiant) {
		if(findByRef(quizEtudiant.getRef()) != null)
		{
			return -1;
		}
		Quiz quiz=quizService.findByRef(quizEtudiant.getQuiz().getRef());
        Etudiant etudiant = etudiantService.findByRef(quizEtudiant.getEtudiant().getRef());
        //ReponseEtudiant reponseEtudiant = reponseEtudiantService.findByRef(quizEtudiant.getReponseEtudiant().getRef());
        quizEtudiant.setQuiz(quiz);
        quizEtudiant.setEtudiant(etudiant);
        //quizEtudiant.setReponseEtudiant(reponseEtudiant);
       if(quiz==null){
          return -2;
       }
       if(etudiant==null){
           return -3;
        }
       /*if(reponseEtudiant==null){
           return -4;
        }*/
		else
		{
			quizEtudiantDao.save(quizEtudiant);
			return 1;
		}
		 
	}

	public List<QuizEtudiant> findAll() {
		return quizEtudiantDao.findAll();
	}

	
}
