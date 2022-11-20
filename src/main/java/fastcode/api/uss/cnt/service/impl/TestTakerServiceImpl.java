package fastcode.api.uss.cnt.service.impl;

import java.util.List;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.uss.domain.TestTaker;
import com.bitcamp.lms.uss.domain.Tutor;
import com.bitcamp.lms.uss.repository.TestTakerRepository;
import com.bitcamp.lms.uss.service.TestTakerService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Service
public class TestTakerServiceImpl implements TestTakerService{
	final TestTakerRepository repository;
	@Override
	public int save(TestTaker param) {
		return repository.save(param);
	}

	@Override
	public int update(TestTaker param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(TestTaker param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<TestTaker> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public TestTaker getOne(String id) {
		return repository.getOne(id);
	}

}
