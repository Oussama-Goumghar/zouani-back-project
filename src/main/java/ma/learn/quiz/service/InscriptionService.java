package ma.learn.quiz.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.EtatInscription;
import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Inscription;
import ma.learn.quiz.bean.Prof;
import ma.learn.quiz.dao.InscriptionDao;





@Service
public class InscriptionService {
	@Autowired
	public InscriptionDao inscriptionDao;
	@Autowired
	public EtatInscriptionService etatInscriptionService;
	@Autowired
	public ParcoursService parcoursService;
	@Autowired
	public ProfService profService;
	@Autowired
	public CentreService centreService;
	@Autowired
	public EtudiantService etudiantService;
	
	 public int save(Inscription  inscription ) {
			if(findByNumeroInscription(inscription.getNumeroInscription())!=null) {
				return -1;
			}
			
			
			
			Etudiant etudiant = etudiantService.findByRef(inscription.getEtudiant().getRef());
			inscription.setEtudiant (etudiant );
			if(etudiant ==null) {
				return -2;
			}
			EtatInscription etatInscription = etatInscriptionService.findByRef(inscription.getEtatInscription().getRef());
			inscription.setEtatInscription(etatInscription);
			if(etatInscription ==null) {
				return -2;
			}
			else {
				etatInscriptionService.save(etatInscription);
				etudiantService.save(etudiant);
				inscriptionDao.save(inscription);
				return 1;
			}
				
		}
	
	
	 public int valider(Inscription inscription){	
			Optional<Inscription> Inscription = findById(inscription.getId());
			Inscription loadedInscription= Inscription.get();
			EtatInscription etatInscription=etatInscriptionService.findByRef(inscription.getEtatInscription().getRef());
			loadedInscription.setEtatInscription(etatInscription);
			Prof prof=profService.findProfById(inscription.getProf().getId());
			loadedInscription.setProf(prof);
			inscriptionDao.save(loadedInscription);
			return 1;
		 }
	
	



		private Optional<Inscription> findById(Long id) {
		
		return null;
	}


		public Inscription findByEtudiantRef(String ref) {
			return inscriptionDao.findByEtudiantRef(ref);
		}





	


	public int deleteByEtudiantRef(String ref) {
			return inscriptionDao.deleteByEtudiantRef(ref);
		}








		public int deleteByEtatInscriptionRef(String ref) {
			return inscriptionDao.deleteByEtatInscriptionRef(ref);
		}








	@Transactional
	public int deleteByNumeroInscription(int numeroInscription) {
		return inscriptionDao.deleteByNumeroInscription(numeroInscription);
	}
	

	

	
	public Inscription findByNumeroInscription(int numeroInscription) {
		return inscriptionDao.findByNumeroInscription(numeroInscription);
	}



}
