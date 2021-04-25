package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Centre;
import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Inscription;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.dao.InscriptionDao;





@Service
public class InscriptionService {
	@Autowired
	public InscriptionDao inscriptionDao;
	
	@Autowired
	public ParcoursService parcoursService;
	@Autowired
	public CentreService centreService;
	@Autowired
	public EtudiantService etudiantService;
	
	 public int save(Inscription  inscription ) {
			if(findBynumeroInscription(inscription.getNumeroInscription())!=null) {
				return -1;
			}
			Parcours parcours= parcoursService.findByRef(inscription.getParcours().getRef());
			inscription.setParcours(parcours);
			if(parcours==null) {
				return -3;
			}
			Centre centre= centreService.findByref(inscription.getCentre().getRef());
			inscription.setCentre(centre);
			if(centre==null) {
				return -4;
			}
			Etudiant etudiant = etudiantService.findByref(inscription.getEtudiant().getRef());
			inscription.setEtudiant (etudiant );
			if(etudiant ==null) {
				return -5;
			}
			
			else {
				inscriptionDao.save(inscription);
				return 1;
			}
				
		}
	
	
	
	
	
	 public List<Inscription> findByCentreRef(String ref) {
			return inscriptionDao.findByCentreRef(ref);
		}





		public Inscription findByEtudiantRef(String ref) {
			return inscriptionDao.findByEtudiantRef(ref);
		}





	public List<Inscription> findByParcoursRef(String ref) {
		return inscriptionDao.findByParcoursRef(ref);
	}



	@Transactional
	public int deleteBynumeroInscription(String numeroInscription) {
		return inscriptionDao.deleteBynumeroInscription(numeroInscription);
	}
	

	

	
	public Inscription findBynumeroInscription(String numeroInscription) {
		return inscriptionDao.findBynumeroInscription(numeroInscription);
	}



}
