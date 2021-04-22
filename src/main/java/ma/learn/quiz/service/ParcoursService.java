package ma.learn.quiz.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Parcours;
import ma.learn.quiz.dao.ParcoursDao;

@Service
public class ParcoursService {	

    @Autowired
    private ParcoursDao parcoursDao;
    @Autowired
    private ParcoursItemService parcoursItemService;

	public Parcours findByCode(String code) {
		return parcoursDao.findByCode(code);
	}

	@Transactional
	public int deleteByCode(String code) {
		int deleteByParcoursCode=parcoursItemService.deleteByParcoursCode(code);
		int deleteByCode=parcoursDao.deleteByCode(code);
		return deleteByParcoursCode+deleteByCode;
	}

	public int save(Parcours parcours) {
		if(findByCode(parcours.getCode())!=null) {
			return -1;
		}else {
			
			parcoursDao.save(parcours);
			parcoursItemService.save(parcours,parcours.getParcoursItems());
			return 1;
		}
		
	}



	public List<Parcours> findAll() {
		return parcoursDao.findAll();
	}

	public void delete(Parcours entity) {
		parcoursDao.delete(entity);
	}
   
}
