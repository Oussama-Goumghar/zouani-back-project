package ma.learn.quiz.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Admin;
import ma.learn.quiz.bean.Prof;
import ma.learn.quiz.bean.RecommendTeacher;
import ma.learn.quiz.bean.SessionCours;
import ma.learn.quiz.dao.ProfDao;
import ma.learn.quiz.vo.SalaryVo;

@Service
public class ProfService {
    public Prof findByNumero(String ref) {
        return profDao.findByNumero(ref);
    }

	public int deleteByNumero(String ref) {
        return profDao.deleteByNumero(ref);
    }

    public Prof findProfById(Long id) {
		return profDao.findProfById(id);
	}

	public List<Prof> findAll() {
        return profDao.findAll();
    }
	public int save(Prof prof ) {
		if(findProfById(prof.getId())!=null) {
			return -1;
		}
		else {
			System.out.println("id::: " + prof.getId());
			profDao.save(prof);
			return 1;
		}
			
	}
    public List<SessionCours> calcStatistique(SalaryVo salaryVo) {
    	/*String query = "SELECT NEW ma.learn.quiz.vo.SalaryVo(COUNT(s.id)) FROM SessionCours s WHERE s.mois = ? and s.annee=?";
    	System.out.println("query = " + query); 
    	int res = entityManager.createQuery(query).getResultList(); 
    	System.out.println("res = " + res); 
    	return res; */
    	String query = "SELECT Count(s.id) From SessionCours s where s.dateDebut = '"+ salaryVo.getAnnee()+"/"+ salaryVo.getMois()+"/01'";
    	return entityManager.createQuery(query).getResultList();
    }
    
    public Prof findByRef(String ref) {
        return profDao.findByRef(ref);
    }

    public int deleteByRef(String ref) {
        return profDao.deleteByRef(ref);
    }
    

    public Prof findByNom(String Nom) {
		return profDao.findByNom(Nom);
	}

	public Object findByCritere(String login, String password)
	{
		String query = "SELECT p FROM Prof p WHERE p.login= '"+login+"' and p.password='"+password+"'";
		return entityManager.createQuery(query).getSingleResult();
	}
    @Autowired 
	public EntityManager entityManager;
    @Autowired
    private ProfDao profDao;
   
}