package fastcode.api.cmm.db.service;

import fastcode.api.cop.article.service.vo.ArticleVO;
import fastcode.api.cop.article.service.vo.BoardVO;
import fastcode.api.cop.article.service.vo.ReplyVO;
import fastcode.api.sym.dep.service.vo.CompanyVO;
import fastcode.api.sym.dep.service.vo.DepartmentVO;
import fastcode.api.dam.train.service.vo.CourseVO;
import fastcode.api.dam.train.service.vo.SubjectVO;
import fastcode.api.ext.geomap.service.GeomapVO;
import fastcode.api.uat.cnt.service.vo.OauthVO;
import fastcode.api.ext.scrap.service.ScrapVO;
import fastcode.api.sts.acc.service.vo.AccountingVO;
import fastcode.api.sts.grade.service.GradeVO;

public interface IDDLService {
	/* bbs */
	ArticleVO makeArticle();
	BoardVO makeBoard();
	ReplyVO makeReply();
	/* cop */
	CompanyVO makeCompany();
	DepartmentVO makeDepartment();
	/* ext */
	GeomapVO mekeGeomap();
	OauthVO makeOauth();
	ScrapVO makeScrap();
	/* itm */
	CourseVO makeCourse();
	SubjectVO makeSubject();
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
