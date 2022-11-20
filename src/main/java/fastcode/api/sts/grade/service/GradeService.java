package fastcode.api.sts.grade.service;

import com.bitcamp.lms.aim.domain.Grade;
import com.bitcamp.lms.dwh.service.CrudService;
public interface GradeService extends CrudService<GradeVO>{
	public void insertMany();
}