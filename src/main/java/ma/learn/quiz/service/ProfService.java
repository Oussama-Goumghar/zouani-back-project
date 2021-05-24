package ma.learn.quiz.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Prof;
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
    public int save(Prof prof){
        this.profDao.save(prof);
        return 1;
    }
    public List<SalaryVo> calcStatistique(SalaryVo salaryVo) {
    	String query = "SELECT NEW ma.clc.vo.SalaryVo(COUNT(s.id)) FROM SessionCours s WHERE s.mois = ? and s.anne.=?";
    	System.out.println("query = " + query); 
    	List<SalaryVo> res = entityManager.createQuery(query).getResultList(); 
    	System.out.println("res = " + res); 
    	return res; 

    }
    @Autowired 
	public EntityManager entityManager;
    @Autowired
    private ProfDao profDao;
}
