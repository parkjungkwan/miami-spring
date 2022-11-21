package fastcode.api.cop.adm.service.vo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data  @Lazy
public class CopSmsVO {
	private int smsNo;
	private String smsDate;
	private String smsMsg;
	private String progress;
	private String timStatus;
	private int timNo;
	private String timName;
	
}
