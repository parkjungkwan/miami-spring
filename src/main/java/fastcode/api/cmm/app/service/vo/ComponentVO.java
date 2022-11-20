package fastcode.api.cmm.app.service.vo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data @Lazy
public class ComponentVO {
	private int cmid;
	private String cmtext;
	private String cmalias;
	private String cmtype;
	private int app;
	private int usage;
	
}


