package fastcode.api.cop.article.service.dao;
import fastcode.api.cmm.app.service.dao.AppDAO;
import fastcode.api.cop.article.service.vo.BoardVO;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardDAO extends AppDAO<BoardVO> {

}
