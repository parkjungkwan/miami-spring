package fastcode.api.cop.adm.service.dao;

import fastcode.api.cmm.app.service.dao.AppDAO;
import fastcode.api.cop.sms.service.vo.SmsVO;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsDAO extends AppDAO<SmsVO> {
}
