package fastcode.api.uss.cnt.service.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.uss.domain.Manager;
@Repository
public interface ManagerDAO extends CrudRepository<Manager>{
	public Optional<Manager> access(Manager p);

}
