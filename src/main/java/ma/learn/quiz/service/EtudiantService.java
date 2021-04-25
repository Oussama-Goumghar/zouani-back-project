package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.dao.EtudiantDao;




@Service
public class EtudiantService {
	@Autowired
	public  EtudiantDao  etudiantDao;
	
	@Autowired
	public CentreService centreService;
	@Autowired
	public ParcoursService parcoursService;
	
	 public List<Etudiant> findByParcoursRef(String ref) {
		return etudiantDao.findByParcoursRef(ref);
	}
	 public int save(Etudiant  etudiant ) {
			if(findByref(etudiant.getRef())!=null) {
				return -1;
			}
			Parcours parcours=parcoursService.findByRef(etudiant.getParcours().getRef());
			etudiant.setParcours(parcours);
			if(parcours==null) {
				return -3;
			}
			else {
				 etudiantDao.save(etudiant);
				return 1;
			}
				
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

	public Etudiant findByref(String ref) {
		return etudiantDao.findByref(ref);
	}

	public Etudiant findBynom(String nom) {
		return etudiantDao.findBynom(nom);
	}
	
	@Transactional
	public int deleteByref(String ref) {
		return centreService.deleteByref(ref);
	}
	@Transactional
	public int deleteBynom(String nom) {
		return etudiantDao.deleteBynom(nom);
	}

	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}
	

}
