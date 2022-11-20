package fastcode.api.ext.oauth.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.ext.domain.Oauth;
import com.bitcamp.lms.ext.repository.OauthRepository;
import com.bitcamp.lms.ext.repository.ScrapRepository;
import com.bitcamp.lms.ext.service.OauthService;
import com.bitcamp.lms.ext.service.ScrapService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class OauthServiceImpl implements OauthService{
	final OauthRepository repository;
	public int save(Oauth param) {
		return repository.save(param);
	}
	public int update(Oauth param) {
		return repository.update(param);
	}
	public int count() {
		return repository.count();
	}
	public int delete(Oauth param) {
		return repository.delete(param);
	}
	public boolean exists(String id) {
		return repository.exists(id);
	}
	public List<Oauth> findAll(Page page) {
		return repository.findAll(page);
	}
	public Oauth getOne(String id) {
		return repository.getOne(id);
	}
}
