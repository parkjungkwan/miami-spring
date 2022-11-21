package fastcode.api.cop.adm.web;
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

import com.bitcamp.lms.dwh.domain.Box;
import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.qna.domain.Answer;
import com.bitcamp.lms.qna.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/qna/answers")
public class CopAnswerWeb {
	private final AnswerRepository repository;
	private final Page page;
	private Box<Answer> box;
	
	@PostMapping("")
    public ResponseEntity<Integer> save(@RequestBody Answer param) {
        return ResponseEntity.ok(repository.save(param));
    }
    @PutMapping("")
    public ResponseEntity<Integer> update(@RequestBody Answer param){
    	return ResponseEntity.ok(repository.update(param));
    }
    @GetMapping("/count")
    public ResponseEntity<Integer> count() {
    	int i = repository.count();
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
    @DeleteMapping("")
    public ResponseEntity<Integer> delete(@RequestBody Answer param){
    	return ResponseEntity.ok(repository.delete(param));
    }
    @GetMapping("/{id}")
	public ResponseEntity<Boolean> exists(@PathVariable String id) {
        return new ResponseEntity<>(repository.exists(id), HttpStatus.OK);
	}
    @GetMapping("/all/{pageNo}")
    public ResponseEntity<Box<Answer>> findAll(@PathVariable String pageNo) {
    	page.setPageNo(integer.apply(pageNo));
    	List<Answer> list = repository.findAll(page);
    	box.setList(list);
    	box.setPage(page);
        return new ResponseEntity<>(box, HttpStatus.OK);
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<Answer> getOne(@PathVariable String id) {
        return new ResponseEntity<>(repository.getOne(id), HttpStatus.OK);
    }
    @GetMapping("/all/{pageNo}/size/{pageSize}")
	public ResponseEntity<Map<?, ?>> findByPageNumAndSize(@PathVariable String pageNo, @PathVariable String pageSize) {
    	Map<String,Object> map = new HashMap<>();
    	page.setPageNo(integer.apply(pageNo));
    	page.setPageSize(optInteger(pageSize).orElse(20));
    	map.put("list", repository.findAll(page));
    	map.put("page", page);
        return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
