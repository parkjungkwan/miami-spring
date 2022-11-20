package fastcode.api.sts.grade.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @AllArgsConstructor @Lazy @NoArgsConstructor
public class GradeVO {
	private int grdNo; 
	private int score;
	private int stuNo;
	private int subNo;
    private String grade; 
    private String examDate; 
    private String passExam;
    
   
}