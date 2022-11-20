package fastcode.api.uss.cnt.service.dao;

import org.springframework.stereotype.Repository;

import com.bitcamp.lms.dwh.domain.Box;
import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.itm.domain.Subject;
import com.bitcamp.lms.uss.domain.Student;
@Repository
public interface StudentDAO extends CrudRepository<Student>{
	
}