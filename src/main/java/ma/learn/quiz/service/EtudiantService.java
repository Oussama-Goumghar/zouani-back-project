package ma.learn.quiz.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.EtatInscription;
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
	public ProfService profService;
	@Autowired
	public EtatInscriptionService etatInscriptionService;
	
	@Autowired 
	public EntityManager entityManager;
	
	 public List<Etudiant> findByParcoursCode(String code) {
		return etudiantDao.findByParcoursCode(code);
	}
	
	 
	
	public int deleteByParcoursCode(String code) {
		return etudiantDao.deleteByParcoursCode(code);
	}

	public List<Etudiant> findByCriteria (Etudiant etudiant){
		String query = "SELECT e FROM Etudiant e WHERE 1=1";
		if (etudiant.getNom() != null  )
		{
			query += " AND  e.nom LIKE '%" + etudiant.getNom()+"%'";
		}
		if (etudiant.getPrenom() != null)
		{
			query+= "  AND  e.prenom LIKE '%" + etudiant.getPrenom()+"'";
		}
		if (etudiant.getId() != null)
		{
			query+= "  AND  e.id LIKE '%" + etudiant.getId()+"'";
		}
		if (etudiant.getLogin() != null)
		{
			query+= "  AND  e.login LIKE '%" + etudiant.getLogin()+"'";
		}
		if (etudiant.getPassword() != null)
		{
			query+= "  AND  e.password LIKE '%" + etudiant.getPassword()+"'";
		}
		return  entityManager.createQuery(query).getResultList();	
	}

	public Etudiant findByRef(String ref) {
		return etudiantDao.findByRef(ref);
	}

	public Etudiant findByNom(String nom) {
		return etudiantDao.findByNom(nom);
	}

	public Optional<Etudiant> findById(Long id) {
		return etudiantDao.findById(id);
	}



	public int valider(Etudiant etudiant){	
		Optional<Etudiant> Etudiant = findById(etudiant.getId());
		Etudiant loadedEtudiant= Etudiant.get();
	
		etudiantDao.save(loadedEtudiant);
		return 1;
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
	
	
}
