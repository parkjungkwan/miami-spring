package fastcode.api.sym.dep.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.cop.domain.Company;
import com.bitcamp.lms.cop.repository.CompanyRepository;
import com.bitcamp.lms.cop.service.CompanyService;
import com.bitcamp.lms.dwh.domain.Page;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService{
	final CompanyRepository repository;
	@Override
	public int save(Company param) {
		return repository.save(param);
	}

	@Override
	public int update(Company param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Company param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Company> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Company getOne(String id) {
		return repository.getOne(id);
	}

}
