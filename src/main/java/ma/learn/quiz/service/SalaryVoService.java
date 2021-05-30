package ma.learn.quiz.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ma.learn.quiz.dao.SalaryVoDao;
import ma.learn.quiz.vo.SalaryVo;

@Service
public class SalaryVoService {
@Autowired
private SalaryVoDao Salary;

public List<SalaryVo> findByMoisAndAnnee(Date mois, Date annee) {
	return Salary.findByMoisAndAnnee(mois, annee);
}

public List<SalaryVo> findSalaryVoById(Long id) {
	return Salary.findSalaryVoById(id);
}

public List<SalaryVo> findSalaryVoByProfId(Long id) {
	return Salary.findSalaryVoByProfId(id);
}



}
