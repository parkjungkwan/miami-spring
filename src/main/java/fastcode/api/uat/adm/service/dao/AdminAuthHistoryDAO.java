package fastcode.api.uat.adm.service.dao;

import fastcode.api.uat.adm.service.vo.UserAuthorHistoryVO;
import org.springframework.stereotype.Repository;

import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.sec.domain.CertHistory;
import com.bitcamp.lms.uss.domain.Admin;
import com.bitcamp.lms.uss.domain.TestTaker;
import com.bitcamp.lms.uss.domain.Manager;
import com.bitcamp.lms.uss.domain.Staff;
import com.bitcamp.lms.uss.domain.Student;
import com.bitcamp.lms.uss.domain.Tutor;
import com.bitcamp.lms.uss.domain.User;

@Repository
public interface AdminAuthHistoryDAO extends CrudRepository<UserAuthorHistoryVO>{

	public String findByEmail(String mbEmail);
	
}
