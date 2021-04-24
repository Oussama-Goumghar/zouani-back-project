package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Centre;
import ma.learn.quiz.dao.CentreDao;




@Service
public class CentreService {
	@Autowired
	public CentreDao centredao;
	
	@Autowired
	public InscriptionService inscriptionService;
	@Autowired
	public ParcoursService parcoursService;
	@Autowired
	public EtudiantService etudiantService;
	
	

	

	

	@Transactional
	public int deleteByref(String ref) {
	int resultinscri=	inscriptionService.deleteByref(ref);
		
		int resultat1= etudiantService.deleteByRef(ref);
		int resultat= centredao.deleteByref(ref);
		return resultinscri+resultat+resultat1;
	}

	public List<Centre> findAll() {
		return centredao.findAll();
	}

	public Centre findByref(String ref) {
		return centredao.findByref(ref);
	}
	public int save(Centre centre ) {
		if(findByref(centre.getRef())!=null) {
			return -1;
		}
		/*
		Inscriptionetudiant inscriptionetudiant=inscriptionService.findByref(centre.getInscriptionetudiant().getRef());
		centre.setInscriptionetudiant(inscriptionetudiant);
		if(inscriptionetudiant==null) {
			return -2;
		}
		/*
	Parcours parcours=parcoursService.findByRef(centre.getParcours().getRef());
	centre.setParcours(parcours);
	if(parcours==null) {
		return -2;
	}
	*/
	else {
		centredao.save(centre);
		return 1;
	}
		
}

	/*
	 public int save(Centre centre){
	        if(findByref(centre.getRef())!=null){
	            return -1;
	       
	        }else{
	        	centredao.save(centre);
	            return 1;
	        }
	    }
*/
}
