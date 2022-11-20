package fastcode.api.sym.dep.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.cop.domain.Department;
import com.bitcamp.lms.cop.repository.CompanyRepository;
import com.bitcamp.lms.cop.repository.DepartmentRepository;
import com.bitcamp.lms.cop.service.DepartmentService;
import com.bitcamp.lms.dwh.domain.Page;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService{
	final DepartmentRepository repository;
	public int save(Department param) {
		return repository.save(param);
	}
	public int update(Department param) {
		return repository.update(param);
	}
	public int count() {
		return repository.count();
	}
	public int delete(Department param) {
		return repository.delete(param);
	}
	public boolean exists(String id) {
		return repository.exists(id);
	}
	public List<Department> findAll(Page page) {
		return repository.findAll(page);
	}
	public Department getOne(String id) {
		return repository.getOne(id);
	}
}
