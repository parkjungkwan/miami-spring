package fastcode.api.dam.develop.service;

import java.util.Map;

public interface IDamDevelopService extends CrudService<Tutor>{
	public Map<?,?> findAllBySubject(Box<String> param);
}
