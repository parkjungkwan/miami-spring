package fastcode.api.cop.article.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.bbs.domain.Board;
import com.bitcamp.lms.bbs.repository.BoardRepository;
import com.bitcamp.lms.bbs.service.BoardService;
import com.bitcamp.lms.dwh.domain.Page;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

	final BoardRepository repository;
	@Override
	public int save(Board param) {
		return repository.save(param);
	}

	@Override
	public int update(Board param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Board param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Board> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Board getOne(String id) {
		return repository.getOne(id);
	}

}
