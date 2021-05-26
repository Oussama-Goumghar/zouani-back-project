package ma.learn.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.FaqType;
import ma.learn.quiz.dao.FaqTypeDao;

@Service
public class FaqTypeService {

	@Autowired
	private FaqTypeDao faqTypeDao;
	private FaqService faqService;

	public FaqType findByRef(String ref) {
		return faqTypeDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		int deleteFaq = faqService.deleteByFaqTypeRef(ref);
		int deleyeFaqType = faqTypeDao.deleteByRef(ref);
		return deleteFaq+deleyeFaqType;
	}

	public int save(FaqType faqType) {
		if(findByRef(faqType.getRef()) != null)
		{
			return -1;
		}
		else
		{
			faqTypeDao.save(faqType);
			return 1;
		}
	}

	public List<FaqType> findAll() {
		return faqTypeDao.findAll();
	}
}
