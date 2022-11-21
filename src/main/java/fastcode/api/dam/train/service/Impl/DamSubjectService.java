package fastcode.api.dam.train.service.Impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.aim.domain.Grade;
import com.bitcamp.lms.aim.repository.GradeRepository;
import com.bitcamp.lms.cop.domain.Company;
import com.bitcamp.lms.dwh.domain.Box;
import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.dwh.service.CrudService;
import com.bitcamp.lms.itm.domain.Subject;
import com.bitcamp.lms.itm.repository.SubjectRepository;
import com.bitcamp.lms.itm.service.SubjectService;
import com.bitcamp.lms.olh.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class DamSubjectService implements SubjectService{

	final SubjectRepository repository;
	@Override
	public int save(Subject param) {
		return repository.save(param);
	}

	@Override
	public int update(Subject param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Subject param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Subject> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Subject getOne(String id) {
		return repository.getOne(id);
	}

}
