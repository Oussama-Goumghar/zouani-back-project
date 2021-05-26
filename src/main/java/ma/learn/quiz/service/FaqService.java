package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Faq;
import ma.learn.quiz.dao.FaqDao;

@Service
public class FaqService {

	@Autowired
	private FaqDao faqDao;

	public Faq findByRef(String ref) {
		return faqDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		return faqDao.deleteByRef(ref);
	}

	public List<Faq> findByFaqTypeRef(String ref) {
		return faqDao.findByFaqTypeRef(ref);
	}

	@Transactional
	public int deleteByFaqTypeRef(String ref) {
		return faqDao.deleteByFaqTypeRef(ref);
	}

	public int save(Faq faq) {
		if(findByRef(faq.getRef()) != null)
		{
			return -1;
		}
		else if(findByFaqTypeRef(faq.getFaqType().getRef()) == null)
		{
			return -2;
		}
		else
		{
			faqDao.save(faq);
			return 1;
		}
		
	}

	public List<Faq> findAll() {
		return faqDao.findAll();
	}
}
