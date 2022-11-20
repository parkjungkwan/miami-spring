package fastcode.api.uss.cnt.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.dwh.serviceImpl.TableServiceImpl;
import com.bitcamp.lms.uss.domain.Manager;
import com.bitcamp.lms.uss.domain.Student;
import com.bitcamp.lms.uss.repository.ManagerRepository;
import com.bitcamp.lms.uss.service.ManagerService;


import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Service
public class ManagerServiceImpl implements ManagerService{
	final ManagerRepository repository;
	final TableServiceImpl dummyService;
    
    @Override
	public int save(Manager param) {
		return repository.save(param);
	}

	@Override
	public int update(Manager param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Manager param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Manager> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Manager getOne(String id) {
		return repository.getOne(id);
	}
   

}
