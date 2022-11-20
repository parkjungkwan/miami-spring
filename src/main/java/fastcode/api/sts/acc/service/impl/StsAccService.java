package fastcode.api.sts.acc.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.aim.domain.Stat;
import com.bitcamp.lms.aim.repository.StatRepository;
import com.bitcamp.lms.aim.service.StatService;
import com.bitcamp.lms.bbs.domain.Article;
import com.bitcamp.lms.dwh.domain.Page;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class StsAccService implements StatService{
	final StatRepository repository;
	@Override
	public int save(Stat param) {
		return repository.save(param);
	}

	@Override
	public int update(Stat param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Stat param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Stat> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Stat getOne(String id) {
		return repository.getOne(id);
	}

}
