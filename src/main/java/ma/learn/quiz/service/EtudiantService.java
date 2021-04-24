package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.dao.EtudiantDao;


@Service
public class EtudiantService {

	@Autowired
	private EtudiantDao etudiantDao;
	@Autowired
	private QuizEtudiantService quizEtudiantService;
	@Autowired
	private ReponseEtudiantService reponseEtudiantService;
	@Autowired
	private ParcoursService parcoursService;



	public List<Etudiant> findByParcoursCode(String code) {
		return etudiantDao.findByParcoursCode(code);
	}

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
	public int save(Etudiant  etudiant ) {
		if(findByRef(etudiant.getRef())!=null) {
			return -1;
		}
		Parcours parcours=parcoursService.findByCode(etudiant.getParcours().getCode());
		etudiant.setParcours(parcours);
		if(parcours==null) {
			return -3;
		}
		else {
			 etudiantDao.save(etudiant);
			return 1;
		}
			
	}
 

	

	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}
}
