package fastcode.api.sts.grade.service;

import com.bitcamp.lms.aim.domain.Grade;
import com.bitcamp.lms.dwh.service.CrudService;
import fastcode.api.sts.grade.service.vo.GradeVO;

public interface GradeService extends CrudService<GradeVO>{
	public void insertMany();
}