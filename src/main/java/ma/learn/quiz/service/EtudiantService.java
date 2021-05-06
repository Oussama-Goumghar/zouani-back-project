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
	
	 public List<Etudiant> findByParcoursCode(String code) {
		return etudiantDao.findByParcoursCode(code);
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
				parcoursService.update(parcours);
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

	public Etudiant findByRef(String ref) {
		return etudiantDao.findByRef(ref);
	}

	public Etudiant findByNom(String nom) {
		return etudiantDao.findByNom(nom);
	}
	
	@Transactional
	public int deleteByRef(String ref) {
		return etudiantDao.deleteByRef(ref);
	}
	@Transactional
	public int deleteByNom(String nom) {
		return etudiantDao.deleteByNom(nom);
	}

	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}
	public int deleteByParcoursCode(String code) {
		return etudiantDao.deleteByParcoursCode(code);
	}
	

}
