package fastcode.api.sym.dep.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.cop.domain.Classroom;
import com.bitcamp.lms.cop.repository.ClassroomRepository;
import com.bitcamp.lms.cop.repository.CompanyRepository;
import com.bitcamp.lms.cop.service.ClassroomService;
import com.bitcamp.lms.cop.service.CompanyService;
import com.bitcamp.lms.dwh.domain.Page;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ClassroomServiceImpl implements ClassroomService{
	final ClassroomRepository repository;
	@Override
	public int save(Classroom param) {
		return repository.save(param);
	}

	@Override
	public int update(Classroom param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Classroom param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Classroom> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Classroom getOne(String id) {
		return repository.getOne(id);
	}

}
