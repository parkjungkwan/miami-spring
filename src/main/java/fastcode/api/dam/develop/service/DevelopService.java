package fastcode.api.dam.develop.service;

import java.util.Map;

public interface DevelopService extends CrudService<Tutor>{
	public Map<?,?> findAllBySubject(Box<String> param);
}
