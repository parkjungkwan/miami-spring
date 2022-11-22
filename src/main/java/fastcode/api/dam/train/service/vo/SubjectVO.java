package fastcode.api.dam.train.service.vo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data @Lazy
public class SubjectVO {
	private int subjectNo;
    private String subjectName;
    private String subjectImage;
    private String subjectRegdate;
    
    
   
}

