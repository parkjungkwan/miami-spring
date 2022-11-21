package fastcode.api.cmm.db.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import fastcode.api.cmm.db.service.IDbGenService;
import fastcode.api.cop.article.service.vo.CopArticleVO;
import fastcode.api.cop.article.service.vo.CopBoardVO;
import fastcode.api.cop.article.service.vo.CopReplyVO;
import fastcode.api.sts.grade.service.GradeVO;
import fastcode.api.sym.dep.service.vo.CompanyVO;
import fastcode.api.sym.dep.service.vo.DepartmentVO;
import fastcode.api.dam.train.service.vo.DamCourseVO;
import fastcode.api.dam.train.service.vo.DamSubjectVO;
import fastcode.api.ext.geo.service.GeomapVO;
import fastcode.api.uat.cnt.service.vo.OauthVO;
import fastcode.api.ext.scrap.service.ScrapVO;
import fastcode.api.sts.acc.service.vo.AccountingVO;
import fastcode.api.sym.adm.service.vo.ManagerVO;
import fastcode.api.cop.adm.service.vo.CopNoticeVO;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class DbGenService implements IDbGenService {
	/* bbs */
	@Override public CopArticleVO makeArticle() {
		return new CopArticleVO();
	}
	@Override public CopBoardVO makeBoard() {
		return new CopBoardVO();
	}
	@Override public CopReplyVO makeReply() {
		return new CopReplyVO();
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
	@Override public DamCourseVO makeCourse() {
		return new DamCourseVO();
	}
	@Override public DamSubjectVO makeSubject() {
		List<String> l = Arrays.asList("Java","Spring","Python","jQuery","eGovframe");
		Collections.shuffle(l);
		return new DamSubjectVO();
	}
	/* olh */
	@Override public CopNoticeVO makeNotice() {
		return new CopNoticeVO();
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