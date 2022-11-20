package fastcode.api.cop.article.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.bbs.domain.Article;
import com.bitcamp.lms.bbs.repository.ArticleRepository;
import com.bitcamp.lms.bbs.service.ArticleService;
import com.bitcamp.lms.dwh.domain.Page;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService{

	final ArticleRepository repository;
	@Override
	public int save(Article param) {
		return repository.save(param);
	}

	@Override
	public int update(Article param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Article param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Article> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Article getOne(String id) {
		return repository.getOne(id);
	}

}
