package fastcode.api.cmm.db.service;

public interface IDbMgmService {
	public void create(String sql);
	public void drop(String sql);
	public void truncate(String sql);

}
