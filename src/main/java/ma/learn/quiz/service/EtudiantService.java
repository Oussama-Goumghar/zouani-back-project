package ma.learn.quiz.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Centre;
import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.bean.Prof;
import ma.learn.quiz.dao.EtudiantDao;



@Service
public class EtudiantService {
	@Autowired
	public  EtudiantDao  etudiantDao;
	
	@Autowired
	public CentreService centreService;
	@Autowired
	public ParcoursService parcoursService;
	
	@Autowired 
	public EntityManager entityManager;
	
	 public List<Etudiant> findByParcoursCode(String code) {
		return etudiantDao.findByParcoursCode(code);
	}
	
	 
	
	/*

	public int save(Etudiant etudiant){
	        if(findByref(etudiant.getRef())!=null){
	            return -1;
	       
	        }else{
	        	etudiantDao.save(etudiant);
	            return 1;
	        }
	    }
	    */

	public int deleteByParcoursCode(String code) {
		return etudiantDao.deleteByParcoursCode(code);
	}



	public Etudiant findByRef(String ref) {
		return etudiantDao.findByRef(ref);
	}

	public Etudiant findByNom(String nom) {
		return etudiantDao.findByNom(nom);
	}

	public void valider(Etudiant etudiant){	
		etudiant.setEtat(etudiant.getEtat());
		etudiantDao.save(etudiant);
		
	 }
	public int save(Etudiant  etudiant ) {
		if(findByNom(etudiant.getNom())!=null) {
			

			return -1;
		}
		Parcours parcours =parcoursService.findParcoursByLibelle(etudiant.getParcours().getLibelle());
		
		if(parcours==null) {
			return -3;
		}
		
		
		else {
			etudiant.setParcours(parcours);
		
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
		String query = "SELECT e FROM Etudiant e WHERE e.login= '"+login+"' and e.password='"+password+"'";
		return entityManager.createQuery(query).getSingleResult();
	}

}
