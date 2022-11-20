package fastcode.api.ext.scrap.service;
import org.springframework.stereotype.Repository;

import com.bitcamp.lms.dwh.repository.CrudRepository;
import com.bitcamp.lms.ext.domain.Geomap;
import com.bitcamp.lms.ext.domain.Crawler;

@Repository
public interface ScrapDAO extends CrudRepository<ScrapVO>{

}
