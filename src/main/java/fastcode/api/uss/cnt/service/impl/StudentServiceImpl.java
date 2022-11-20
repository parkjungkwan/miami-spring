package fastcode.api.uss.cnt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.uss.domain.Student;
import com.bitcamp.lms.uss.repository.StudentRepository;
import com.bitcamp.lms.uss.repository.TestTakerRepository;
import com.bitcamp.lms.uss.service.StudentService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Service
public class StudentServiceImpl implements StudentService{
	final StudentRepository repository;
	@Override
	public int save(Student param) {
		return repository.save(param);
	}

	@Override
	public int update(Student param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Student param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Student> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Student getOne(String id) {
		return repository.getOne(id);
	}
}
