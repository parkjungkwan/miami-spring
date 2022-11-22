package fastcode.api.uat.adm.service;

import com.bitcamp.lms.sec.domain.CertHistory;
import fastcode.api.uat.adm.service.vo.UserAuthorHistoryVO;

public interface UserAuthorHistoryService {
	public void sendAuthMail(UserAuthorHistoryVO certHistory);
	public String generateAuthCode(int size);  // 인증코드 난수 발생
}
