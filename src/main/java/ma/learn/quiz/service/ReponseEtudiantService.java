package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Question;
import ma.learn.quiz.bean.QuizEtudiant;
import ma.learn.quiz.bean.Reponse;
import ma.learn.quiz.bean.ReponseEtudiant;
import ma.learn.quiz.dao.ReponseEtudiantDao;



@Service
public class ReponseEtudiantService {

	@Autowired
	private ReponseEtudiantDao reponseEtudiantDao;
	@Autowired
	private QuizEtudiantService quizEtudiantService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ReponseService reponseService;
	@Autowired
	private EtudiantService etudiantService;

	public ReponseEtudiant findByRef(String ref) {
		return reponseEtudiantDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String Ref) {
		return reponseEtudiantDao.deleteByRef(Ref);
	}

	public List<ReponseEtudiant> findByQuestionRef(String ref) {
		return reponseEtudiantDao.findByQuestionRef(ref);
	}

	public List<ReponseEtudiant> findByEtudiantRef(String ref) {
		return reponseEtudiantDao.findByEtudiantRef(ref);
	}

	@Transactional
	public int deleteByQuestionRef(String ref) {
		return reponseEtudiantDao.deleteByQuestionRef(ref);
	}

	@Transactional
	public int deleteByEtudiantRef(String ref) {
		return reponseEtudiantDao.deleteByEtudiantRef(ref);
	}

	public int save(ReponseEtudiant reponseEtudiant) {
		if(findByRef(reponseEtudiant.getRef())!=null)
		{
			return -1;
		}
		Question question= questionService.findByRef(reponseEtudiant.getQuestion().getRef());
        Etudiant etudiant = etudiantService.findByRef(reponseEtudiant.getEtudiant().getRef());
        Reponse reponse = reponseService.findByRef(reponseEtudiant.getReponse().getRef());
        QuizEtudiant quizEtudiant = quizEtudiantService.findByRef(reponseEtudiant.getQuizEtudiant().getRef());
        reponseEtudiant.setQuestion(question);
        reponseEtudiant.setEtudiant(etudiant);
        reponseEtudiant.setReponse(reponse);
        if(question==null){
            return -2;
         }
         if(etudiant==null){
             return -3;
          }
         if(reponse==null){
             return -4;
          }
         if(quizEtudiant==null)
         {
        	 return -5;
         }
         else {
        	 reponseEtudiantDao.save(reponseEtudiant);
        	 return 1;
         }
	}

	public List<ReponseEtudiant> findAll() {
		return reponseEtudiantDao.findAll();
	}

	
}
