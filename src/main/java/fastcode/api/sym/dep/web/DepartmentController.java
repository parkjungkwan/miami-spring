package fastcode.api.sym.dep.web;

import static com.bitcamp.lms.dwh.utility.Util.integer;
import static com.bitcamp.lms.dwh.utility.Util.optInteger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fastcode.api.sym.dep.service.vo.DepartmentVO;
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

import com.bitcamp.lms.cop.domain.Department;
import com.bitcamp.lms.cop.serviceImpl.DepartmentServiceImpl;
import com.bitcamp.lms.dwh.controller.CrudController;
import com.bitcamp.lms.dwh.domain.Box;
import com.bitcamp.lms.dwh.domain.Page;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cop/departments")
public class DepartmentController  extends CrudController<DepartmentVO>{
	private final Page page;
    private final Box<DepartmentVO> box;
    private final DepartmentServiceImpl service;
    
    @PostMapping("")
    public ResponseEntity<Integer> save(@RequestBody DepartmentVO param) {
        return ResponseEntity.ok(service.save(param));
    }
    @PutMapping("")
    public ResponseEntity<Integer> update(@RequestBody DepartmentVO param){
    	return ResponseEntity.ok(service.update(param));
    }
    @GetMapping("/count")
    public ResponseEntity<Integer> count() {
    	int i = service.count();
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
    @DeleteMapping("")
    public ResponseEntity<Integer> delete(@RequestBody DepartmentVO param){
    	return ResponseEntity.ok(service.delete(param));
    }
    @GetMapping("/{id}")
	public ResponseEntity<Boolean> exists(@PathVariable String id) {
        return new ResponseEntity<>(service.exists(id), HttpStatus.OK);
	}
    @GetMapping("/all/{pageNo}")
    public ResponseEntity<Box<DepartmentVO>> findAll(@PathVariable String pageNo) {
    	page.setPageNo(integer.apply(pageNo));
    	List<DepartmentVO> list = service.findAll(page);
    	box.setList(list);
    	box.setPage(page);
        return new ResponseEntity<>(box, HttpStatus.OK);
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<DepartmentVO> getOne(@PathVariable String id) {
        return new ResponseEntity<>(service.getOne(id), HttpStatus.OK);
    }
    @GetMapping("/all/{pageNo}/size/{pageSize}")
	public ResponseEntity<Map<?, ?>> findAllPerSize(@PathVariable String pageNo, @PathVariable String pageSize) {
    	Map<String,Object> map = new HashMap<>();
    	page.setPageNo(integer.apply(pageNo));
    	page.setPageSize(optInteger(pageSize).orElse(20));
    	map.put("list", service.findAll(page));
    	map.put("page", page);
        return new ResponseEntity<>(map, HttpStatus.OK);
	}
    
}
