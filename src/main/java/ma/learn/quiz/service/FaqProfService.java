package ma.learn.quiz.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.FaqProf;
import ma.learn.quiz.dao.FaqProfDao;


@Service
public class FaqProfService {

	@Autowired
	private FaqProfDao faqProfDao;

	public List<FaqProf> findAll() {
		return faqProfDao.findAll();
	}

	public Optional<FaqProf> findById(Long id) {
		return faqProfDao.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		faqProfDao.deleteById(id);
	}

	public List<FaqProf> findByFaqTypeId(Long id) {
		return faqProfDao.findByFaqTypeId(id);
	}

	@Transactional
	public int deleteByFaqTypeId(Long id) {
		return faqProfDao.deleteByFaqTypeId(id);
	}

	public List<FaqProf> findByProfId(Long id) {
		return faqProfDao.findByProfId(id);
	}

	@Transactional
	public int deleteByProfId(Long id) {
		return faqProfDao.deleteByProfId(id);
	}

	public int save(FaqProf faqProf) {
		if(findById(faqProf.getId()) != null)
		{
			return -1;
		}
		else if(findByFaqTypeId(faqProf.getFaqType().getId()) == null)
		{
			return -2;
		}
		else
		{
			faqProfDao.save(faqProf);
			return 1; 
		}
	}

	
	
}
