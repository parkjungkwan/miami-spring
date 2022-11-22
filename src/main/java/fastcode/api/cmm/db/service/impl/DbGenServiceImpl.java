package fastcode.api.cmm.db.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import fastcode.api.cmm.db.service.DbGenService;
import fastcode.api.cop.bbs.service.vo.ArticleVO;
import fastcode.api.cop.bbs.service.vo.BoardVO;
import fastcode.api.cop.bbs.service.vo.ReplyVO;
import fastcode.api.sts.grade.service.vo.GradeVO;
import fastcode.api.sym.dep.service.vo.CompanyVO;
import fastcode.api.sym.dep.service.vo.DepartmentVO;
import fastcode.api.dam.train.service.vo.CourseVO;
import fastcode.api.dam.train.service.vo.SubjectVO;
import fastcode.api.ext.geo.service.GeomapVO;
import fastcode.api.uat.cnt.service.vo.OauthVO;
import fastcode.api.ext.scrap.service.vo.ScrapVO;
import fastcode.api.sts.acc.service.vo.AccountingVO;
import fastcode.api.sym.adm.service.vo.ManagerVO;
import fastcode.api.cop.adm.service.vo.NoticeVO;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class DbGenServiceImpl implements DbGenService {
	/* bbs */
	@Override public ArticleVO makeArticle() {
		return new ArticleVO();
	}
	@Override public BoardVO makeBoard() {
		return new BoardVO();
	}
	@Override public ReplyVO makeReply() {
		return new ReplyVO();
	}
	/* cop */
	@Override public CompanyVO makeCompany() {
		return new CompanyVO();
	}
	@Override public DepartmentVO makeDepartment() {
		return new DepartmentVO();
	}
	/* ext */
	@Override public GeomapVO mekeGeomap() {
		return new GeomapVO();
	}
	@Override public OauthVO makeOauth() {
		return new OauthVO();
	}
	@Override public ScrapVO makeScrap() {
		return new ScrapVO();
	}
	/* itm */
	@Override public CourseVO makeCourse() {
		return new CourseVO();
	}
	@Override public SubjectVO makeSubject() {
		List<String> l = Arrays.asList("Java","Spring","Python","jQuery","eGovframe");
		Collections.shuffle(l);
		return new SubjectVO();
	}
	/* olh */
	@Override public NoticeVO makeNotice() {
		return new NoticeVO();
	}
	/* sec */
	@Override public AuthHistoryVO makeAuth() {
		return new AuthHistoryVO();
	}
	/* sts */
	@Override public GradeVO makeGrade(int stuSq, int sbjSq) {
		return new GradeVO();
	}
	@Override public AccountingVO makeStat() {
		return new AccountingVO();
	}
	/* uss */
	@Override public ManagerVO makeManager() {
		return new ManagerVO();
	}
	@Override public UssCntVO makeStudent(int mgrSq) {
		return new StudentVO();
	}
	@Override public TutorVO makeTeacher(int sbjSq) {
		return new TutorVO();
	}
	
	
}