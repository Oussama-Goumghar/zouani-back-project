package ma.learn.quiz.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.EtatInscription;
import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Inscription;
import ma.learn.quiz.bean.Parcours;
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
		    Parcours parcours = parcoursService.findParcoursById(inscription.getParcours().getId());
			EtatInscription etatInscription = etatInscriptionService.findEtatInscriptionById((long) 1);
			Prof prof=profService.findProfById((long) 15);
			inscription.setProf(prof);
			inscription.setEtatInscription(etatInscription);
			inscriptionDao.save(inscription);
				return 1;		
		}
	
	
	 public int valider(Inscription inscription){	
		    System.out.println(inscription.getEtatInscription().getId());
			Inscription loadedInscription = findInscriptionById(inscription.getId());
			EtatInscription etatInscription=etatInscriptionService.findEtatInscriptionById(inscription.getEtatInscription().getId());
			EtatInscription etat = etatInscriptionService.findEtatInscriptionById((long) 2);
			loadedInscription.setEtatInscription(etatInscription);	
			loadedInscription.setProf(inscription.getProf());
			if (etatInscription.getId() == 2) {
				Etudiant etudiant = new Etudiant();
				etudiant.setAddress(loadedInscription.getAddress());
				etudiant.setAge(loadedInscription.getAge());
				etudiant.setEtatInscription(etatInscription);
				etudiant.setLogin(loadedInscription.getLogin());
				etudiant.setNom(loadedInscription.getNom());
				etudiant.setParcours(loadedInscription.getParcours());
				etudiant.setProf(inscription.getProf());
				etudiant.setPassword(loadedInscription.getPassword());
				etudiant.setPrenom(loadedInscription.getPrenom());
				etudiant.setRef(loadedInscription.getRef());
				etudiant.setVille(loadedInscription.getVille());
				System.out.println(etudiant.getNom());
				etudiantService.create(etudiant);
				return 1;
			}else {
				inscriptionDao.save(loadedInscription);
			return 2;
			}
		 }
	
	



		public List<Inscription> findAll() {
		return inscriptionDao.findAll();
	}


		


		@Transactional
		public int deleteInscriptionById(List<Inscription> inscription) {
			int res=0;
	        for (int i = 0; i < inscription.size(); i++) {
	            res+=deleteInscriptionById(inscription.get(i).getId());
	        }
	        return res;
		}
		
		@Transactional
		public int deleteInscriptionById(Long id) {
			return inscriptionDao.deleteInscriptionById(id);
		}


		public Inscription findInscriptionById(Long id) {
			return inscriptionDao.findInscriptionById(id);
		}


		public int deleteByEtatInscriptionRef(String ref) {
			return inscriptionDao.deleteByEtatInscriptionRef(ref);
		}



	public int deleteByRef(String ref) {
			return inscriptionDao.deleteByRef(ref);
		}


	@Transactional
	public int deleteByNumeroInscription(int numeroInscription) {
		return inscriptionDao.deleteByNumeroInscription(numeroInscription);
	}
	

	

	
	public Inscription findByNumeroInscription(int numeroInscription) {
		return inscriptionDao.findByNumeroInscription(numeroInscription);
	}



}
