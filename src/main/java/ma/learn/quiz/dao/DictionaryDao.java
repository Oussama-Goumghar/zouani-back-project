package ma.learn.quiz.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.learn.quiz.bean.Dictionary;



public interface DictionaryDao extends JpaRepository<Dictionary, Long>  {
	Dictionary findByWord(String word);
	Dictionary findDictionaryById (Long id);

}