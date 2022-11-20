package fastcode.api.uss.cnt.service.impl;

import java.util.List;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.uss.domain.Staff;
import com.bitcamp.lms.uss.repository.StaffRepository;
import com.bitcamp.lms.uss.repository.StudentRepository;
import com.bitcamp.lms.uss.service.StaffService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Service
public class StaffServiceImpl implements StaffService{
	final StaffRepository repository;
	@Override
	public int save(Staff param) {
		return repository.save(param);
	}

	@Override
	public int update(Staff param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Staff param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Staff> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Staff getOne(String id) {
		return repository.getOne(id);
	}

}
