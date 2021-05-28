package ma.learn.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.learn.quiz.bean.Cours;
import ma.learn.quiz.bean.Prof;
import ma.learn.quiz.bean.RecommendTeacher;
import ma.learn.quiz.dao.RecommendTeacherDao;

@Service
public class RecommendTeacherService {

	
	@Autowired
	public RecommendTeacherDao recommendTeacherDao;
	@Autowired
	public RecommendTeacherService recommendTeacherService;
	@Autowired
	public ProfService profService;
	public RecommendTeacher findByRef(String ref) {
		return recommendTeacherDao.findByRef(ref);
	}
	public List<RecommendTeacher> findAll() {
		return recommendTeacherDao.findAll();
	}
	public int save(RecommendTeacher  recommendTeacher ) {
RecommendTeacher recommend =recommendTeacherDao.findRecommendTeacherByProf(recommendTeacher.getProf());

		
		if(recommend==null) {
			recommendTeacher.setProf(recommendTeacher.getProf());
			recommendTeacher.setNombrevote(recommendTeacher.getNombrevote()+1);
			recommendTeacherDao.save(recommendTeacher);
			return 4;
    
		}else {
			recommendTeacherService.update(recommendTeacher);
			return 1;
			}
		}
	public RecommendTeacher findByProfNom(String nom) {
		return recommendTeacherDao.findByProfNom(nom);
	}
	public Optional<RecommendTeacher> findById(Long id) {
		return recommendTeacherDao.findById(id);
	}
	
	public RecommendTeacher update(RecommendTeacher  recommendTeacher) {
		RecommendTeacher recommend =recommendTeacherDao.findRecommendTeacherByProf(recommendTeacher.getProf());
		recommend.setNombrevote(recommend.getNombrevote()+1);
		return recommendTeacherDao.save(recommend);
	}
	
	

}
