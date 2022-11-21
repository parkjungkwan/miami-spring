package fastcode.api.dam.train.service.vo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
* 커리큘럼을 나타내는 도메인  클래스
* @author 프로젝트 매니저 박정관
* @since 2021.02.10
* @version 1.0
* @see DamCurriculumVO.java
*
* 
* << 개정이력(Modification Information) >>
*   
*   수정일              수정자           수정내용
*  ----------  -------  ---------------------------
*   2021.2.15   박정관          최초 생성

CREATE TABLE ai_curriculum (
	cur_no INT PRIMARY KEY auto_increment,
	cur_title VARCHAR(30) NOT NULL,
	reg_date INT DEFAULT 0
)



*/

@Component
@Data @Lazy
public class DamCurriculumVO {

}
