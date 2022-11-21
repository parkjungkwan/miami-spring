package fastcode.api.cmm.db.service;

import fastcode.api.cop.article.service.vo.CopArticleVO;
import fastcode.api.cop.article.service.vo.CopBoardVO;
import fastcode.api.cop.article.service.vo.CopReplyVO;
import fastcode.api.sym.dep.service.vo.CompanyVO;
import fastcode.api.sym.dep.service.vo.DepartmentVO;
import fastcode.api.dam.train.service.vo.DamCourseVO;
import fastcode.api.dam.train.service.vo.DamSubjectVO;
import fastcode.api.ext.geo.service.GeomapVO;
import fastcode.api.uat.cnt.service.vo.OauthVO;
import fastcode.api.ext.scrap.service.ScrapVO;
import fastcode.api.sts.acc.service.vo.AccountingVO;
import fastcode.api.sts.grade.service.GradeVO;

public interface IDbGenService {
	/* bbs */
	CopArticleVO makeArticle();
	CopBoardVO makeBoard();
	CopReplyVO makeReply();
	/* cop */
	CompanyVO makeCompany();
	DepartmentVO makeDepartment();
	/* ext */
	GeomapVO mekeGeomap();
	OauthVO makeOauth();
	ScrapVO makeScrap();
	/* itm */
	DamCourseVO makeCourse();
	DamSubjectVO makeSubject();
	/* olh */
	NoticeVO makeNotice();
	/* sec */
	AuthHistoryVO makeAuth();
	/* sts */
	GradeVO makeGrade(int stuSq, int sbjSq);
	AccountingVO makeStat();
	/* uss */
	ManagerVO makeManager();
	StudentVO makeStudent(int mgrSq);
    DevelopVO makeTeacher(int sbjSq);

}
