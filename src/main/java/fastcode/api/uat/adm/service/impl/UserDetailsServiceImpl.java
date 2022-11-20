package fastcode.api.uat.adm.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.bitcamp.lms.dwh.service.CrudService;
import com.bitcamp.lms.qna.domain.Answer;
import com.bitcamp.lms.sec.repository.AuthRepository;
import com.bitcamp.lms.uss.domain.Manager;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private AuthRepository authRepository;

	@Override
	public UserDetails loadUserByUsername(String inputUserId) {

		// 최종적으로 리턴해야할 객체
		UserDetails userDetails = null;

		// 사용자 정보 select
		Manager manager = authRepository.selectUserInfoOne(inputUserId);

		// 사용자 정보 없으면 null 처리
		if (manager == null) {
			return null;

		// 사용자 정보 있을 경우 로직 전개 (userDetails에 데이터 넣기)
		} else {
			//userDetails.setUsername(manager.getMbId());
			//userDetails.setPassword(manager.getPassword());

			// 사용자 권한 select해서 받아온 List<String> 객체 주입
			//userDetails.setAuthorities(authMapper.selectUserAuthOne(inputUserId));
		}

		return null;//userDetails;
	}
}
