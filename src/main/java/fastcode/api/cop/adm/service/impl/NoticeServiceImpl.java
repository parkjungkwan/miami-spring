package fastcode.api.cop.adm.service.impl;
import java.util.List;

import fastcode.api.cop.adm.service.NoticeService;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {
	final NoticeRepository repository;
	@Override
	public int save(Notice param) {
		return repository.save(param);
	}

	@Override
	public int update(Notice param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Notice param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Notice> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Notice getOne(String id) {
		return repository.getOne(id);
	}
}
