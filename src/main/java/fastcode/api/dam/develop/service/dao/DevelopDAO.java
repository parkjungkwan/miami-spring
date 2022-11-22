package fastcode.api.dam.develop.service.dao;

import java.util.List;
import java.util.Optional;

import com.bitcamp.lms.dwh.domain.Vector;
import com.bitcamp.lms.dwh.map.GradeMap;
import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.itm.domain.Subject;
import com.bitcamp.lms.uss.domain.Student;
import com.bitcamp.lms.uss.domain.Tutor;

import org.springframework.stereotype.Repository;
@Repository
public interface DevelopDAO extends CrudRepository<Tutor>{
	public Optional<Tutor> access(Tutor p);
	public List<Tutor> findAllTeachers();
}
