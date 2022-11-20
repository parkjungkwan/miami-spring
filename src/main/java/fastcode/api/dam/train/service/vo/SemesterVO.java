package fastcode.api.dam.train.service.vo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.bitcamp.lms.dwh.controller.HomeController;

import lombok.Data;

/**
* 몇회 기수를 나타내는 도메인  클래스
* @author 프로젝트 매니저 박정관
* @since 2021.02.10
* @version 1.0
* @see SemesterVO.java
*
* 
* << 개정이력(Modification Information) >>
*   
*   수정일              수정자           수정내용
*  ----------  -------  ---------------------------
*   2021.2.10   박정관          최초 생성
* 
*/

@Component
@Data @Lazy
public class SemesterVO {
	private int semNo;
	private int semId; // *** 기
	private String semTitle;
	private int startDate; // unix time
	private int endDate; // unix time
	private String branch; // 지점
	private String classroom;
	private int tutNo;
	private int mbrId;
	
}


