package fastcode.api.cop.bbs.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements IReplyService{

	final ReplyRepository repository;
	@Override
	public int save(Reply param) {
		return repository.save(param);
	}

	@Override
	public int update(Reply param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Reply param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Reply> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Reply getOne(String id) {
		return repository.getOne(id);
	}
}
