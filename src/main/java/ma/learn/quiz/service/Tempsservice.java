package ma.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Temps;
import ma.learn.quiz.dao.TempsDao;



@Service
public class Tempsservice {
	@Autowired
	public TempsDao horaireDao;

	public List<Temps> findAll() {
		return horaireDao.findAll();
	}

	public Temps findHoraireByref(String ref) {
		return horaireDao.findHoraireByref(ref);
	}

	

}
