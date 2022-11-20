package fastcode.api.uss.cnt.service.dao;

import org.springframework.stereotype.Repository;

import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.uss.domain.Student;
import com.bitcamp.lms.uss.domain.TestTaker;

@Repository
public interface TestTakerDAO extends CrudRepository<TestTaker>{

}
