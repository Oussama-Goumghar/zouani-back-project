package ma.learn.quiz.service;

import ma.learn.quiz.bean.Admin;
import ma.learn.quiz.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;

@Service
public class AdminService {
    public Admin findByNumero(String ref) {
        return adminDao.findByNumero(ref);
    }

    public int deleteByNumero(String ref) {
        return adminDao.deleteByNumero(ref);
    }

    public List<Admin> findAll() {
        return adminDao.findAll();
    }
    public int save(Admin admin){
        this.adminDao.save(admin);
        return 1;
    }

    public Object findByCritere(String login, String password)
	{
		String query = "SELECT a FROM Admin a WHERE a.login= '"+login+"' and a.password='"+password+"'";
		return entityManager.createQuery(query).getSingleResult();
	}
    
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private EntityManager entityManager;
}
