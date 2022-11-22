package fastcode.api.cop.bbs.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements IBoardService{

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
