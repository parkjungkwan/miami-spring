package fastcode.api.dam.train.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.itm.domain.Course;
import com.bitcamp.lms.itm.repository.CourseRepository;
import com.bitcamp.lms.itm.service.CourseService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class DamCourseService implements CourseService{
	final CourseRepository repository;
	@Override
	public int save(Course param) {
		return repository.save(param);
	}

	@Override
	public int update(Course param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Course param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Course> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Course getOne(String id) {
		return repository.getOne(id);
	}

}
