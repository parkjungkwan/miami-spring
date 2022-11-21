package fastcode.api.cop.article.service.impl;
import java.util.List;

import fastcode.api.cmm.app.service.vo.PageVO;
import fastcode.api.cop.article.service.ICopArticleService;
import fastcode.api.cop.article.service.dao.CopArticleDAO;
import fastcode.api.cop.article.service.vo.CopArticleVO;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class CopArticleService implements ICopArticleService {

	final CopArticleDAO dao;
	@Override
	public int save(CopArticleVO param) {
		return dao.save(param);
	}

	@Override
	public int update(CopArticleVO param) {
		return dao.update(param);
	}

	@Override
	public int count() {
		return dao.count();
	}

	@Override
	public int delete(CopArticleVO param) {
		return dao.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return dao.exists(id);
	}

	@Override
	public List<CopArticleVO> findAll(PageVO page) {
		return dao.findAll(page);
	}

	@Override
	public CopArticleVO getOne(String id) {
		return dao.getOne(id);
	}

}
