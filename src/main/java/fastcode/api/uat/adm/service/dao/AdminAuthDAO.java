package fastcode.api.uat.adm.service.dao;

import fastcode.api.uat.adm.service.UserAuthorHistoryVO;
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
public interface AdminAuthDAO extends CrudRepository<UserAuthorHistoryVO>{
	public Student studentLogin(Student param);
	public Tutor tutorLogin(Tutor param);
	public Manager managerLogin(Manager param);
	public Admin adminLogin(Admin param);
	public User userLogin(User param);
	public Staff staffLogin(Staff param);
	public TestTaker developerLogin(TestTaker developer);
	// 자동로그인 체크한 경우에 사용자 테이블에 세션과 유효시간을 저장하기 위한 메서드
	public void keepStudentLogin(Student param); // String uid, String sessionId, Date next
	public void keepTutorLogin(Tutor param);
	public void keepAdminLogin(Admin param);
	public void keepStaffLogin(Student p);
	public void keepManagerLogin(Student p);
	public void keepDeveloperLogin(Student p);
	// 이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크한다.
	public Student checkUserWithSessionKey(String sessionId);
	
	/*
	alter table userTable add column sessionkey varchar(50) notnull default 'none';
	alter table userTable add column sessionlimit timestamp;


	 * */
	public Manager loginManager(Manager member);
	public Student loginStudent(Student student);
	public Tutor loginTeacher(Tutor student);
	public Manager selectUserInfoOne(String inputUserId);
	public Manager selectUserAuthOne(String inputUserId);
	
	
}
