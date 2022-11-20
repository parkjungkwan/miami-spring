package fastcode.api.sts.grade.service.impl;
import java.util.List;

import fastcode.api.sts.grade.service.GradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bitcamp.lms.aim.domain.Grade;
import com.bitcamp.lms.aim.repository.GradeRepository;
import com.bitcamp.lms.aim.service.GradeService;
import com.bitcamp.lms.bbs.domain.Reply;
import com.bitcamp.lms.bbs.repository.ReplyRepository;
import com.bitcamp.lms.dwh.domain.Box;
import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.dwh.domain.Vector;
import com.bitcamp.lms.dwh.map.GradeMap;
import com.bitcamp.lms.dwh.service.CrudService;
import com.bitcamp.lms.dwh.serviceImpl.TableServiceImpl;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {
	final GradeRepository repository;
	final TableServiceImpl dummy;
	
	@Override @Transactional
	public void insertMany() {
		// int stuNum, int subNum, String examDate, int score
		for(int i=1; i<= 100; i++ ) {
			for(int j=1; j<=5; j++) {
				//gradeMapper.insert(dummy.makeGrade(i, j));
			}
		}
    }
	
	
	@Override
	public int save(Grade param) {
		return repository.save(param);
	}

	@Override
	public int update(Grade param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Grade param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Grade> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Grade getOne(String id) {
		return repository.getOne(id);
	}

}
