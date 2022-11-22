package fastcode.api.dam.train.service.vo;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.bitcamp.lms.qna.domain.Submission;
import com.bitcamp.lms.uss.domain.Student;
import com.bitcamp.lms.uss.domain.Tutor;

import lombok.Data;

@Component
@Data  @Lazy
public class DamTrainVO {
	private int trainId; // 자동증가 시퀀스값
	private String trainTitle;
	private String trainDetails;
	private String trainGoal;  
	private String trainOption; // 프로그램 대상자
	private String trainList; // 차시
	private String trainCapacity; // 참여가능 학생수 
	private String trainDays; // 학습일
	private String trainHours; // 하루 학습시간
	private String trainThreads; // ?
	private String trainComplete; // 과정 완료여부 ?
	private String trainTutor;  // teacher
	private String trainRgdate; // ?
	private String trainMdate; // ?
	private int trainVersion; // ?
	private int trainEnable; // ?
	private int trainCost; // 훈련비용
	private String trainThum;  // ?
	private String trainStart; // 시작일
	private String trainEnd; // 종료일
	private String trainPath; // ?
	
	private int stuNo; private List<Student> students; // 참여한 학습자
	private int teaNo; private List<Tutor> teachers; // 참여한 교강사
	private int cosNo; private CourseVO course; // 과정명세
	private int smid; private List<Submission> submissions; // 평가목록
	
	

}
