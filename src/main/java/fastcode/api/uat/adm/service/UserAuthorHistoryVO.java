package fastcode.api.uat.adm.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data  @Lazy
public class UserAuthorHistoryVO {
	// g5_cert_history
	private int crId;
	private int mbId;
	private String crCompany;
	private String crMethod;
	private String crIp;
	private String crDate; 
	private String crTime;
	private String mbEmail;
	private String uuid;
}
