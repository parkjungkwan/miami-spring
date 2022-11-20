package fastcode.api.cmm.app.service.dao;

import fastcode.api.cmm.app.service.vo.PageVO;

import java.util.List;

public interface AppDAO<T> {
	public int save(T param);
	public int update(T param);
	public int count();
	public int delete(T param);
	public boolean exists(String id);
	public List<T> findAll(PageVO page);
	public T getOne(String id);
	
}
