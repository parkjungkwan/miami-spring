package fastcode.api.util.generics;

import static com.bitcamp.lms.dwh.utility.Util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import fastcode.api.cmm.app.service.vo.PageVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Lazy @Data
public class Box<T> {
	private HashMap<String,T> map;
	private List<T> list;
	private PageVO page;
	public Box() {
		map = new HashMap<String, T>();
		list = new ArrayList<T>();
		page = new PageVO();
	}
	public void clear() {
		map.clear();
		page = new PageVO();
		list = new ArrayList<>();
	}
    public int length() {return list.size();}
	public boolean	containsKey(String key) {return map.containsKey(key);}
	public boolean	containsValue(String value) {return map.containsValue(value);}
	public boolean	isEmpty() {return map.isEmpty();}
	public void put(String s, T t) {map.put(s, t);}
	public void remove(String key) {map.remove(key);}
	public void replace(String key, T t) {map.replace(key, t);}
	public int size() {return map.size();}
	@SuppressWarnings("unchecked")
	public List<T> listValues(String key){return (List<T>) map.get(key);}
	@SuppressWarnings("unchecked")
	public Set<T> setValues(String key){return (Set<T>) map.get(key);}
	
}