package fastcode.api.cop.adm.service.impl;

import java.util.List;


import fastcode.api.cop.adm.service.AnswerService;
import fastcode.api.cop.adm.service.dao.AnswerDAO;
import fastcode.api.cop.adm.service.vo.AnswerVO;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Service
public class AnswerServiceImpl implements AnswerService {

	final AnswerDAO dao;
	@Override
	public int save(AnswerVO param) {
		return dao.save(param);
	}

	@Override
	public int update(AnswerVO param) {
		return dao.update(param);
	}

	@Override
	public int count() {
		return dao.count();
	}

	@Override
	public int delete(AnswerVO param) {
		return dao.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return dao.exists(id);
	}

	@Override
	public List<AnswerVO> findAll(PageVO page) {
		return dao.findAll(page);
	}

	@Override
	public AnswerVO getOne(String id) {
		return dao.getOne(id);
	}

}
