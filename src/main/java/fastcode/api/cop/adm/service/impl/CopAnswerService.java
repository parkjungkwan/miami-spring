package fastcode.api.cop.adm.service.impl;

import java.util.List;


import fastcode.api.cop.adm.service.ICopAnswerService;
import fastcode.api.cop.adm.service.dao.CopAnswerDAO;
import fastcode.api.cop.adm.service.vo.CopAnswerVO;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Service
public class CopAnswerService implements ICopAnswerService {

	final CopAnswerDAO dao;
	@Override
	public int save(CopAnswerVO param) {
		return dao.save(param);
	}

	@Override
	public int update(CopAnswerVO param) {
		return dao.update(param);
	}

	@Override
	public int count() {
		return dao.count();
	}

	@Override
	public int delete(CopAnswerVO param) {
		return dao.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return dao.exists(id);
	}

	@Override
	public List<CopAnswerVO> findAll(PageVO page) {
		return dao.findAll(page);
	}

	@Override
	public CopAnswerVO getOne(String id) {
		return dao.getOne(id);
	}

}
