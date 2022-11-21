package fastcode.api.dam.train.service.Impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.itm.domain.Train;
import com.bitcamp.lms.itm.repository.TrainRepository;
import com.bitcamp.lms.itm.service.TrainService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class DamTrainService implements TrainService{

	final TrainRepository repository;
	@Override
	public int save(Train param) {
		return repository.save(param);
	}

	@Override
	public int update(Train param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Train param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Train> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Train getOne(String id) {
		return repository.getOne(id);
	}

}
