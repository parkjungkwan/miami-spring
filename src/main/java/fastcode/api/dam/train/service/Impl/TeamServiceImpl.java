package fastcode.api.dam.train.service.Impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.itm.domain.Team;
import com.bitcamp.lms.itm.repository.TeamRepository;
import com.bitcamp.lms.itm.service.TeamService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService{

	final TeamRepository repository;
	@Override
	public int save(Team param) {
		return repository.save(param);
	}

	@Override
	public int update(Team param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Team param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Team> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Team getOne(String id) {
		return repository.getOne(id);
	}


}
