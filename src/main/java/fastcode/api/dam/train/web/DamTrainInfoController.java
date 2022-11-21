package fastcode.api.dam.train.web;

import static com.bitcamp.lms.dwh.utility.Util.integer;
import static com.bitcamp.lms.dwh.utility.Util.optInteger;

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
import com.bitcamp.lms.itm.domain.TrainInfo;
import com.bitcamp.lms.itm.service.TrainInfoService;
import com.bitcamp.lms.itm.serviceImpl.TrainInfoServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/itm/trainInfos")
public class DamTrainInfoController extends CrudController<TrainInfo>{
	private final Page page;
    private final Box<TrainInfo> box;
    private final TrainInfoServiceImpl service;
    
    @PostMapping("")
    public ResponseEntity<Integer> save(@RequestBody TrainInfo param) {
        return ResponseEntity.ok(service.save(param));
    }
    @PutMapping("")
    public ResponseEntity<Integer> update(@RequestBody TrainInfo param){
    	return ResponseEntity.ok(service.update(param));
    }
    @GetMapping("/count")
    public ResponseEntity<Integer> count() {
    	int i = service.count();
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
    @DeleteMapping("")
    public ResponseEntity<Integer> delete(@RequestBody TrainInfo param){
    	return ResponseEntity.ok(service.delete(param));
    }
    @GetMapping("/{id}")
	public ResponseEntity<Boolean> exists(@PathVariable String id) {
        return new ResponseEntity<>(service.exists(id), HttpStatus.OK);
	}
    @GetMapping("/all/{pageNo}")
    public ResponseEntity<Box<TrainInfo>> findAll(@PathVariable String pageNo) {
    	page.setPageNo(integer.apply(pageNo));
    	List<TrainInfo> list = service.findAll(page);
    	box.setList(list);
    	box.setPage(page);
        return new ResponseEntity<>(box, HttpStatus.OK);
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<TrainInfo> getOne(@PathVariable String id) {
        return new ResponseEntity<>(service.getOne(id), HttpStatus.OK);
    }
    @GetMapping("/all/{pageNo}/size/{pageSize}")
	public ResponseEntity<Map<?, ?>> findByPageNumAndSize(@PathVariable String pageNo, @PathVariable String pageSize) {
    	Map<String,Object> map = new HashMap<>();
    	page.setPageNo(integer.apply(pageNo));
    	page.setPageSize(optInteger(pageSize).orElse(20));
    	map.put("list", service.findAll(page));
    	map.put("page", page);
        return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
