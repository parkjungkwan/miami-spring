package fastcode.api.uss.dev.web;

import static com.bitcamp.lms.dwh.utility.Util.integer;

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

import com.bitcamp.lms.dwh.controller.CrudController;
import com.bitcamp.lms.dwh.domain.Box;
import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.uss.domain.User;
import com.bitcamp.lms.uss.service.UserService;
import com.bitcamp.lms.uss.serviceImpl.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/uss/users")
public class UssDevController extends CrudController<User>{
	private final UserServiceImpl service;
    private final User user;
    private final Page page;
    private final Box<User> box;
    
    @PostMapping("")
    public ResponseEntity<Integer> save(@RequestBody User param) {
    	  //param.setSsn(param.getYear().substring(2, 4)+param.getMonth()+param.getDay());
	      Date d = new Date();
	      SimpleDateFormat reg = new SimpleDateFormat("yyyy-MM-dd");
		  //param.setRegDate(reg.format(d));	  
		  //param.setProfileImg("default.jpg");
        return ResponseEntity.ok(service.save(param));
    }
    @PutMapping("")
    public ResponseEntity<Integer> update(@RequestBody User param){
    	return ResponseEntity.ok(service.update(param));
    }
    @GetMapping("/count")
    public ResponseEntity<Integer> count() {
    	int i = service.count();
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
    @DeleteMapping("")
    public ResponseEntity<Integer> delete(@RequestBody User param){
    	return ResponseEntity.ok(service.delete(param));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Boolean> exists(@PathVariable String id) {
        return new ResponseEntity<>(service.exists(id), HttpStatus.OK);
    }
    @GetMapping("/all/{pageNo}")
    public ResponseEntity<Box<User>> findAll(@PathVariable String pageNo) {
    	page.setPageNo(integer.apply(pageNo));
    	box.setList(service.findAll(page));
    	box.setPage(page);
        return new ResponseEntity<>(box, HttpStatus.OK);
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<User> getOne(@PathVariable String id) {
        return new ResponseEntity<>(service.getOne(id), HttpStatus.OK);
    }
   
    @GetMapping("/all/{pageNo}/size/{pageSize}")
	public ResponseEntity<Map<?,?>> findByPageNumAndSize(@PathVariable String pageSize, @PathVariable String pageNo) {
		Map<String,Object> map = new HashMap<>();
    	page.setPageNo(integer.apply(pageNo));
    	// page.setPageSize(optInteger(pageSize).orElse(20));
    	map.put("list", service.findAll(page));
    	map.put("page", page);
        return new ResponseEntity<>(map, HttpStatus.OK);
	}


}
