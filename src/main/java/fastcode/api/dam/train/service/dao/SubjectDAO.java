package fastcode.api.dam.train.service.dao;
import java.util.List;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.dwh.map.GradeMap;
import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.ext.domain.Crawler;
import com.bitcamp.lms.itm.domain.Subject;

import org.springframework.stereotype.Repository;
@Repository
public interface SubjectDAO extends CrudRepository<Subject>{

	List<GradeMap> findAllGradeMap(Page page);
	

}
