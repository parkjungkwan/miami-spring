package fastcode.api.uss.cnt.web;

import com.bitcamp.lms.aim.serviceImpl.GradeServiceImpl;
import com.bitcamp.lms.dwh.controller.CrudController;
import com.bitcamp.lms.dwh.domain.Box;
import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.dwh.enums.Uss;
import com.bitcamp.lms.dwh.exception.ApiException;
import com.bitcamp.lms.itm.serviceImpl.SubjectServiceImpl;
import com.bitcamp.lms.uss.domain.Student;
import com.bitcamp.lms.uss.repository.StudentRepository;
import com.bitcamp.lms.uss.serviceImpl.ManagerServiceImpl;
import com.bitcamp.lms.uss.serviceImpl.StudentServiceImpl;
import com.bitcamp.lms.uss.serviceImpl.TutorServiceImpl;

import static com.bitcamp.lms.dwh.utility.Util.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/uss/students")
public class ClientController extends CrudController<Student>{
	private final GradeServiceImpl gradeService;
    private final StudentServiceImpl studentService;
    private final StudentRepository repository;
    private final SubjectServiceImpl subjectService;
    private final TutorServiceImpl teacherService;
    private final ManagerServiceImpl managerService;
    private final Student student;
    private final Page page;
    private final Box<Student> box;
    
    @PostMapping("")
    public ResponseEntity<Integer> save(@RequestBody Student param) {
    	  //param.setSsn(param.getYear().substring(2, 4)+param.getMonth()+param.getDay());
	      Date d = new Date();
	      SimpleDateFormat reg = new SimpleDateFormat("yyyy-MM-dd");
		  //param.setRegDate(reg.format(d));	  
		  //param.setProfileImg("default.jpg");
        return ResponseEntity.ok(repository.save(student));
    }
    @PutMapping("")
    public ResponseEntity<Integer> update(@RequestBody Student s){
    	return ResponseEntity.ok(repository.update(s));
    }
    @GetMapping("/count")
    public ResponseEntity<Integer> count() {
    	int i = repository.count();
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
    @DeleteMapping("")
    public ResponseEntity<Integer> delete(@RequestBody Student s){
    	return ResponseEntity.ok(repository.delete(s));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Boolean> exists(@PathVariable String id) {
        return new ResponseEntity<>(repository.exists(id), HttpStatus.OK);
    }
    @GetMapping("/all/{pageNo}")
    public ResponseEntity<Box<Student>> findAll(@PathVariable String pageNo) {
    	page.setPageNo(integer.apply(pageNo));
    	box.setList(repository.findAll(page));
    	box.setPage(page);
        return new ResponseEntity<>(box, HttpStatus.OK);
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<Student> getOne(@PathVariable String id) {
        return new ResponseEntity<>(repository.getOne(id), HttpStatus.OK);
    }
   
    @GetMapping("/all/{pageNo}/size/{pageSize}")
	public ResponseEntity<Map<?,?>> findByPageNumAndSize(@PathVariable String pageSize, @PathVariable String pageNo) {
		Map<String,Object> map = new HashMap<>();
    	page.setPageNo(integer.apply(pageNo));
    	// page.setPageSize(optInteger(pageSize).orElse(20));
    	map.put("list", repository.findAll(page));
    	map.put("page", page);
        return new ResponseEntity<>(map, HttpStatus.OK);
	}
   
}
