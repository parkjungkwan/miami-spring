package fastcode.api.cop.article.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.bbs.domain.Reply;
import com.bitcamp.lms.bbs.repository.ReplyRepository;
import com.bitcamp.lms.bbs.service.ReplyService;
import com.bitcamp.lms.dwh.domain.Page;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService{

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
