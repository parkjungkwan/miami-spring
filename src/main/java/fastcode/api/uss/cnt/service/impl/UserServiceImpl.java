package fastcode.api.uss.cnt.service.impl;

import java.util.List;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.uss.domain.User;
import com.bitcamp.lms.uss.repository.TutorRepository;
import com.bitcamp.lms.uss.repository.UserRepository;
import com.bitcamp.lms.uss.service.UserService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Service
public class UserServiceImpl implements UserService {
	private final UserRepository repository;
	@Override
	public int save(User param) {
		return repository.save(param);
	}

	@Override
	public int update(User param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(User param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<User> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public User getOne(String id) {
		return repository.getOne(id);
	}

}
