package fastcode.api.cop.bbs.service.impl;
import java.util.List;

import fastcode.api.cmm.app.service.vo.PageVO;
import fastcode.api.cop.bbs.service.ArticleService;
import fastcode.api.cop.bbs.service.dao.CopArticleDAO;
import fastcode.api.cop.bbs.service.vo.ArticleVO;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

	final CopArticleDAO dao;
	@Override
	public int save(ArticleVO param) {
		return dao.save(param);
	}

	@Override
	public int update(ArticleVO param) {
		return dao.update(param);
	}

	@Override
	public int count() {
		return dao.count();
	}

	@Override
	public int delete(ArticleVO param) {
		return dao.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return dao.exists(id);
	}

	@Override
	public List<ArticleVO> findAll(PageVO page) {
		return dao.findAll(page);
	}

	@Override
	public ArticleVO getOne(String id) {
		return dao.getOne(id);
	}

}
