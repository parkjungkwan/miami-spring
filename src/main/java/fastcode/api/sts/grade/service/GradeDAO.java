package fastcode.api.sts.grade.service;
import org.springframework.stereotype.Repository;

import com.bitcamp.lms.aim.domain.Grade;
import com.bitcamp.lms.dwh.domain.Vector;
import com.bitcamp.lms.dwh.map.GradeMap;
import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.itm.domain.Subject;

@Repository
public interface GradeDAO extends CrudRepository<Grade>{

}
