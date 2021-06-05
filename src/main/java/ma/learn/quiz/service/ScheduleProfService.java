package ma.learn.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.learn.quiz.bean.Etudiant;
import ma.learn.quiz.bean.ScheduleProf;
import ma.learn.quiz.dao.ScheduleProfDao;
import ma.learn.quiz.vo.SchdeduleVo;

@Service
public class ScheduleProfService {
	public ScheduleProf findByRef(String ref) {
		return scheduleProfDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		return scheduleProfDao.deleteByRef(ref);
	}

	public int save(ScheduleProf scheduleProf) {
		Etudiant etudiant = etudiantService.findByRef(scheduleProf.getEtudiant().getRef());
		scheduleProf.setEtudiant(etudiant);
		if (findByRef(scheduleProf.getRef()) != null) {
			return -1;
		} else {
			//etudiantService.update(etudiant);
			scheduleProfDao.save(scheduleProf);
			return 1;
		}

	}

	public List<SchdeduleVo> findSchedule() {
		List<ScheduleProf> sheduls = scheduleProfDao.findAll();
		List<SchdeduleVo> schdeduleVos = new ArrayList<SchdeduleVo>();
		for (ScheduleProf s : sheduls) {
			SchdeduleVo schdeduleVo = new SchdeduleVo();
			schdeduleVo.setId(s.getId());
			schdeduleVo.setTitle(s.getEtudiant().getNom());
			schdeduleVo.setStart(s.getDateDebut());
			schdeduleVo.setEnd(s.getDateFin());
			schdeduleVo.setRef(s.getRef());
			if (s.getEtudiant().getEtatInscription().getId() == 1) {
				schdeduleVo.setColor("green");
			} else {
				schdeduleVo.setColor("red");
			}
			schdeduleVos.add(schdeduleVo);
		}
		return  schdeduleVos;
	}



	public List<ScheduleProf> findAll() {
		return scheduleProfDao.findAll();
	}

	public Optional<ScheduleProf> findById(Long id) {
		return scheduleProfDao.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		scheduleProfDao.deleteById(id);
	}

	@Autowired
	private ScheduleProfDao scheduleProfDao;
	@Autowired
	private EtudiantService etudiantService;
}
