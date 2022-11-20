package fastcode.api.sym.adm.service.impl;

import java.util.List;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.uss.domain.Admin;
import com.bitcamp.lms.uss.repository.AdminRepository;
import com.bitcamp.lms.uss.repository.ManagerRepository;
import com.bitcamp.lms.uss.service.AdminService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
	final AdminRepository repository;
	@Override
	public int save(Admin param) {
		return repository.save(param);
	}

	@Override
	public int update(Admin param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Admin param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Admin> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Admin getOne(String id) {
		return repository.getOne(id);
	}

}
