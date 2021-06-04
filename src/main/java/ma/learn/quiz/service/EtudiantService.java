package ma.learn.quiz.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Centre;
import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.Prof;
import ma.learn.quiz.dao.EtudiantDao;
import ma.learn.quiz.service.vo.EtudiantVo;



@Service
public class EtudiantService {
	@Autowired
	public  EtudiantDao  etudiantDao;
	
	@Autowired
	public CentreService centreService;
	@Autowired
	public ParcoursService parcoursService;
	@Autowired
	public ProfService profService;
	@Autowired
	public EtatInscriptionService etatInscriptionService;
	
	@Autowired 
	public EntityManager entityManager;
	
	 public List<Etudiant> findByParcoursCode(String code) {
		return etudiantDao.findByParcoursCode(code);
	}
	
	

	public List<Etudiant> findEtudiantByProfId(Long id) {
		return etudiantDao.findEtudiantByProfId(id);
	}



	public Prof findProfById(Long id) {
		return profService.findProfById(id);
	}



	public int deleteByParcoursCode(String code) {
		return etudiantDao.deleteByParcoursCode(code);
	}

	public List<Etudiant> findByCriteria (EtudiantVo etudiantVo){
		String query = "SELECT e FROM Etudiant e WHERE 1=1";
		if (etudiantVo.getNom() != null  )
		{
			query += " AND  e.nom LIKE '%" + etudiantVo.getNom()+"%'";
		}
		if (etudiantVo.getPrenom() != null)
		{
			query+= "  AND  e.prenom LIKE '%" + etudiantVo.getPrenom()+"'";
		}
		
		if (etudiantVo.getLogin() != null)
		{
			query+= "  AND  e.login LIKE '%" + etudiantVo.getLogin()+"'";
		}
		
		return  entityManager.createQuery(query).getResultList();	
	}

	public Etudiant findByRef(String ref) {
		return etudiantDao.findByRef(ref);
	}

	public Etudiant findByNom(String nom) {
		return etudiantDao.findByNom(nom);
	}

	


/*
	public int valider(Inscription inscription){	
		Optional<Inscription> Inscription = findInscriptionById(inscription.getId());
		Inscription loadedInscription= Inscription.get();
		EtatInscription etatInscription=etatInscriptionService.findByRef(etudiant.getEtatInscription().getRef());
		loadedInscription.setEtatInscription(etatInscription);
		Prof prof=profService.findProfById(inscription.getProf().getId());
		loadedInscription.setProf(prof);
		inscriptionDao.save(loadedInscriptiont);
		return 1;
	 }
	*/
	public int save(Etudiant  etudiant ) {
		
		Parcours parcours =parcoursService.findParcoursById(etudiant.getParcours().getId());
		Prof prof = profService.findProfById(etudiant.getProf().getId());
		if(prof == null ) {
			Prof proftest = profService.findProfById((long) 15);
			etudiant.setParcours(parcours);
			etudiant.setCentre(parcours.getCentre());
		etudiant.setProf(proftest);
			 etudiantDao.save(etudiant);
			return 1;
		}
		if(parcours==null) {
			return -3;
		}
		
		else {
			etudiant.setParcours(parcours);
			etudiant.setCentre(parcours.getCentre());
		etudiant.setProf(prof);
			 etudiantDao.save(etudiant);
			return 1;}
		}
	@Transactional
	public int deleteByRef(String ref) {
		return etudiantDao.deleteByRef(ref);
	}
	

	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}



	public int deleteByParcoursId(Long id) {
		return etudiantDao.deleteByParcoursId(id);
	}
	
	

	 public Object findByCritere(String login, String password)
		{
			String query = "SELECT a FROM Etudiant a WHERE a.login= '"+login+"' and a.password='"+password+"'";
			return entityManager.createQuery(query).getSingleResult();
		}
	    

	public Optional<Etudiant> findEtudiantById(Long id) {
		return etudiantDao.findEtudiantById(id);
	}




}
