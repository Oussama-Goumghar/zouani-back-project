package ma.learn.quiz.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Section;
import ma.learn.quiz.dao.SectionDao;

@Service
public class SectionService {

	@Autowired
	public SectionDao sectionDao;
	@Autowired
	public CategorieSectionService categorieSectionService;
	

   public Section findByCode(String code) {
		return sectionDao.findByCode(code);
	}

   @Transactional
	public int deleteByCode(String code) {
		int rslt2 =categorieSectionService.deleteBySectionCode(code);
		int rslt1 = sectionDao.deleteByCode(code);
		 return  rslt2+rslt1;
	}

	 public int save(Section section) {
		if (findByCode(section.getCode())!=null) {
			return -1;
		}

		else {
			
			sectionDao.save(section);
			return  1;

		}
	}
	

public List<Section> findAll() {
		return sectionDao.findAll();
	}

public void update(Section section){
		sectionDao.save(section);
   }

  
	
   
   
}

	

