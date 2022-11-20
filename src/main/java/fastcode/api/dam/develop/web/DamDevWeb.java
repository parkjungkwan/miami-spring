package fastcode.api.dam.develop.web;

import static com.bitcamp.lms.dwh.utility.Util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.lms.dwh.controller.CrudController;
import com.bitcamp.lms.dwh.domain.Box;
import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.dwh.enums.Uss;
import com.bitcamp.lms.dwh.exception.ApiException;
import com.bitcamp.lms.uss.domain.Tutor;
import com.bitcamp.lms.uss.repository.TutorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/uss")
public class DamDevWeb extends CrudController<Tutor>{
    private final Page page;
    private final Box<Tutor> box;
    private final TutorRepository repository;
    @PostMapping("/tutors")
    public ResponseEntity<Integer> save(@RequestBody Tutor teacher) {
        return ResponseEntity.ok(repository.save(teacher));
    }
    @PutMapping("/tutors")
    public ResponseEntity<Integer> update(@RequestBody Tutor param){
    	return ResponseEntity.ok(repository.update(param));
    }
    @GetMapping("/tutors/count")
    public ResponseEntity<Integer> count() {
        return new ResponseEntity<>(repository.count(), HttpStatus.OK);
    }
    @DeleteMapping("/tutors")
    public ResponseEntity<Integer> delete(@RequestBody Tutor param){
    	return ResponseEntity.ok(repository.delete(param));
    }
    @GetMapping("/tutors/{id}")
	public ResponseEntity<Boolean> exists(@PathVariable String id) {
        return new ResponseEntity<>(repository.exists(id), HttpStatus.OK);
	}
    @GetMapping("/tutors/all/{pageNo}")
    public ResponseEntity<Box<Tutor>> findAll(@PathVariable String pageNo) {
    	Map<String,Object> map = new HashMap<>();
    	page.setPageNo(integer.apply(pageNo));
    	box.setList(repository.findAll(page));
    	box.setPage(page);
        return new ResponseEntity<>(box, HttpStatus.OK);
    }
    @GetMapping("/tutors/one/{id}")
    public ResponseEntity<Tutor> getOne(@PathVariable String id) {
        return new ResponseEntity<>(repository.getOne(id), HttpStatus.OK);
    }
    @GetMapping("/tutors/all/{pageNo}/size/{pageSize}")
	public ResponseEntity<Map<?, ?>> findByPageNumAndSize(@PathVariable String pageSize,
															@PathVariable String pageNo) {
    	Map<String,Object> map = new HashMap<>();
    	page.setPageNo(integer.apply(pageNo));
    	page.setPageSize(optInteger(pageSize).orElse(20));
    	map.put("list", repository.findAll(page));
    	map.put("page", page);
        return new ResponseEntity<>(map, HttpStatus.OK);
	}
    /**
     * Teacher 처리
     * */
    @GetMapping("/teachers/all")
    public List<Tutor> findAllTeachers() {
    	List<Tutor> l = repository.findAllTeachers();
    	for(Tutor t : l) {
    		if(t == null) {
    			System.out.println("Null ");
    		}else {
    			System.out.println(t.toString());
    		}
    		
    	}
        return l;
    }
    
    
    
}
