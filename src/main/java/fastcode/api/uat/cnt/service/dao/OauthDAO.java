package fastcode.api.uat.cnt.service.dao;
import fastcode.api.uat.cnt.service.vo.OauthVO;
import org.springframework.stereotype.Repository;

import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.ext.domain.Geomap;
import com.bitcamp.lms.ext.domain.Oauth;

@Repository
public interface OauthDAO extends CrudRepository<OauthVO>{

}
