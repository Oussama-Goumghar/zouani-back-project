package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.dao.EtudiantDao;


@Service
public class EtudiantService {

	@Autowired
	private EtudiantDao etudiantDao;
	@Autowired
	private QuizEtudiantService quizEtudiantService;
	@Autowired
	private ReponseEtudiantService reponseEtudiantService;

	public Etudiant findByRef(String ref) {
		return etudiantDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		int etudiant = etudiantDao.deleteByRef(ref);
		int quizEtudiant = quizEtudiantService.deleteByRef(ref);
		int reponseEtudiant = reponseEtudiantService.deleteByRef(ref);
		return etudiant+quizEtudiant+reponseEtudiant;
	}

	public int save(Etudiant etudiant) {
		if(findByRef(etudiant.getRef())!=null)
		{
			return -1;
		}
		else
		{
			etudiantDao.save(etudiant);
			return 1;
		}
	}

	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}
}
