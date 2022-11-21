package fastcode.api.cmm.db.service.dao;
import java.util.List;
import java.util.Map;

import fastcode.api.cmm.app.service.dao.AppDAO;
import fastcode.api.cmm.app.service.vo.ComponentVO;
import fastcode.api.cop.article.service.vo.CopWriteVO;
import org.springframework.stereotype.Repository;

@Repository
public interface DbGenDAO extends AppDAO<ComponentVO> {
	public void create(String query);
	public void drop(String query);
	public void truncate(String query);
	public ComponentVO getComponents();
	public String getMosaDap();
	public String getJedo();
	public String getHoonJedo();
	public String getHoonJin();
	public String getFooter();
	public String getWelcomeAiAcademy();
	public String getIntroduceAiAcademy();
	public List<ComponentVO> getProcedure();
	public List<CopWriteVO> getTest();
	public List<CopWriteVO> existTable();
	public Map<?,?> showCreateTable(String param);
	public void dropTable(String param);
	public void createNewTable(String param);
}
