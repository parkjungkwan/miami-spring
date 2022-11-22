package fastcode.api.dam.train.service.dao;

import org.springframework.stereotype.Repository;

import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.itm.domain.Team;
import com.bitcamp.lms.itm.domain.Train;

@Repository
public interface TrainDAO extends CrudRepository<Train> {

}
