package fastcode.api.ext.scrap.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.ext.domain.Crawler;
import com.bitcamp.lms.ext.repository.ScrapRepository;
import com.bitcamp.lms.ext.service.ScrapService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ScrapServiceImpl implements ScrapService{
	final ScrapRepository repository;
	@Override
	public int save(Crawler param) {
		return repository.save(param);
	}

	@Override
	public int update(Crawler param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Crawler param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Crawler> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Crawler getOne(String id) {
		return repository.getOne(id);
	}
}
