package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Inscription;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.dao.InscriptionDao;





@Service
public class InscriptionService {
	@Autowired
	public InscriptionDao inscriptionDao;
	@Autowired
	public ParcoursService parcoursService;
	
	 public int save(Inscription  inscriptionetudiant ) {
			if(findByref(inscriptionetudiant.getRef())!=null) {
				return -1;
			}
			Parcours parcours=parcoursService.findByRef(inscriptionetudiant.getParcours().getRef());
			inscriptionetudiant.setParcours(parcours);
			if(parcours==null) {
				return -3;
			}
			else {
				inscriptionDao.save(inscriptionetudiant);
				return 1;
			}
				
		}
	
	
	
	
	





	public List<Inscription> findByParcoursRef(String ref) {
		return inscriptionDao.findByParcoursRef(ref);
	}










	@Transactional
	public int deleteBynumeroInscription(String numeroInscription) {
		return inscriptionDao.deleteBynumeroInscription(numeroInscription);
	}
	@Transactional
	public int deleteByref(String ref) {
	return	 inscriptionDao.deleteByref(ref);
	}

	

	
	public Inscription findBynumeroInscription(String numeroInscription) {
		return inscriptionDao.findBynumeroInscription(numeroInscription);
	}

	public Inscription findByref(String ref) {
		return inscriptionDao.findByref(ref);
	}
	

}
