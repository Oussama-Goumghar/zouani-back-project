package ma.learn.quiz.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Dictionary;
import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.dao.DictionaryDao;

@Service
public class DictionaryService {
	 @Autowired
	 private DictionaryDao dictionaryDao;
	 @Autowired
	 private EtudiantService etudiantService;
	public Dictionary findByWord(String word) {
		return dictionaryDao.findByWord(word);
	}

	public Dictionary findByWordAndEtudiantId(String word, Long id) {
		return dictionaryDao.findByWordAndEtudiantId(word, id);
	}

	public Dictionary findDictionaryById(Long id) {
		return dictionaryDao.findDictionaryById(id);
	}

	public List<Dictionary> findAll() {
		return dictionaryDao.findAll();
	}
	 
	 public int save(Dictionary dictionary ) {
		 Etudiant etudiant = etudiantService.findEtudiantById(dictionary.getEtudiant().getId());
		 if(etudiant == null) {
			 return -2;
		 }
			if(findDictionaryById(dictionary.getId())!=null) {
				return -1;
			}
			
			else {
				
				 dictionary.setEtudiant(etudiant);
				dictionaryDao.save(dictionary);
				return 1;
			}
				
		}
}