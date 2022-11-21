package fastcode.api.cop.article.service.vo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data  @Lazy
public class CopWriteVO {  // g5_write_management
	private int wrId;
	private String wrName;
	private String wrEmail;
	private String wrPhone; // wr_2
	private String wrBranch; //  wr_7 서초지점
	private String wrDatetime;
	private String wrSubject;
}
/*
SELECT 
	    	wr_id wrId, 
	    	wr_subject wrSubject,
	    	wr_name wrName,
	    	wr_email wrEmail,
	    	wr_datetime wrDatetime,
	    	wr_2 wrPhone,
	    	wr_7 wrBranch
			 FROM g5_write_management;
 */