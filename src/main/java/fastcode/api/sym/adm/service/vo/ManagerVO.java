package fastcode.api.sym.adm.service.vo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data  @Lazy
public class ManagerVO {
	 private String mbrNo; // mbr_id
	 private String mbrLoginid;
	 private String mbrLoginpw;
	 private String mbrName;
	 private String mbNick;
	 private String mbNickDate;
	 private String mbEmail;
	 private String mbHomepage;
	 private String mbLevel;
	 private String mbSex;
	 private String mbBirth;
	 private String mbTel;
	 private String mbHp;
	 private String mbrRgdate;
	 private String mbrState;
	 private int roleId;
	 private boolean useCookie;
}
