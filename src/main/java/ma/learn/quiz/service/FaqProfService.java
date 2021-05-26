package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.FaqProf;
import ma.learn.quiz.dao.FaqProfDao;


@Service
public class FaqProfService {

	@Autowired
	private FaqProfDao faqProfDao;

	public FaqProf findByRef(String ref) {
		return faqProfDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		return faqProfDao.deleteByRef(ref);
	}

	public List<FaqProf> findByFaqTypeRef(String ref) {
		return faqProfDao.findByFaqTypeRef(ref);
	}

	@Transactional
	public int deleteByFaqTypeRef(String ref) {
		return faqProfDao.deleteByFaqTypeRef(ref);
	}

	public List<FaqProf> findByProfRef(String ref) {
		return faqProfDao.findByProfRef(ref);
	}

	@Transactional
	public int deleteByProfRef(String ref) {
		return faqProfDao.deleteByProfRef(ref);
	}

	public int save(FaqProf faqProf) {
		if(findByRef(faqProf.getRef()) != null)
		{
			return -1;
		}
		else if(findByFaqTypeRef(faqProf.getFaqType().getRef()) == null)
		{
			return -2;
		}
		else
		{
			faqProfDao.save(faqProf);
			return 1; 
		}
	}
	
	public void update(FaqProf faqProf)
	{
		faqProf.setAdmin(faqProf.getAdmin());
		faqProf.setDescription(faqProf.getDescription());
		faqProfDao.save(faqProf);
	}

	public List<FaqProf> findAll() {
		return faqProfDao.findAll();
	}

	
}
