package fastcode.api.dam.train.service.dao;

import org.springframework.stereotype.Repository;

import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.itm.domain.Subject;
import com.bitcamp.lms.itm.domain.Team;
@Repository
public interface TeamDAO extends CrudRepository<Team>{

}
