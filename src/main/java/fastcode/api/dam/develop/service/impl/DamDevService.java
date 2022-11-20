package fastcode.api.dam.develop.service.impl;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

import fastcode.api.dam.develop.service.IDamDevService;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class DamDevService implements IDamDevService {
	private final TutorRepository repository;
	private final GradeRepository gradeRepository;
	private final SubjectRepository subjectRepository;
	private final TableServiceImpl dummyService;
	private final Page page;
	private final Box<Tutor> teaBox;

	@Override 
	public Map<?,?> findAllBySubject(Box<String> param){
		String pageNo = ""; //param.get("pageNum").toString();
		String pageSize = ""; //param.get("pageSize").toString();
		page.setPageNo(integer.apply(pageNo));
		List<GradeMap> list = subjectRepository.findAllGradeMap(page);
    	Map<String, Object> map = new HashMap<>();
    	
    	IntSummaryStatistics is =list.stream().collect(summarizingInt(GradeMap::getScore));// 204
    	map.put("max", is.getMax());
    	map.put("min", is.getMin());
    	map.put("sum", integer.apply(
    			string.apply(is.getSum())));
    	map.put("avg", integer.apply(
    			string.apply(is.getAverage())));
    	map.put("count", integer.apply(
    			string.apply(is.getCount())));
    	
    	
    	map.put("list", list.stream()
			    	    	.skip(mySkip.apply(pageNo, pageSize))
			    	    	.limit(integer.apply(pageSize))
			    	    	.collect(toList()));
    	
    	map.put("page", new Page(integer.apply(pageSize), 
    								   integer.apply(pageNo), 
    								   list.size()));   
    	
    	/*map.put("subjects",subjectRepository.findAll(null)
					    	.stream()
					    	.collect(joining(","))); */
    	
    	Optional<GradeMap> highScoreGrade = list.stream()
    			.collect(reducing( (g1, g2) -> g1.getScore() > g2.getScore() ? g1 : g2 ));
    	map.put("highScoreGrade", highScoreGrade);
		return map;
	}



	@Override
	public int save(Tutor param) {
		return repository.save(param);
	}

	@Override
	public int update(Tutor param) {
		return repository.update(param);
	}

	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public int delete(Tutor param) {
		return repository.delete(param);
	}

	@Override
	public boolean exists(String id) {
		return repository.exists(id);
	}

	@Override
	public List<Tutor> findAll(Page page) {
		return repository.findAll(page);
	}

	@Override
	public Tutor getOne(String id) {
		return repository.getOne(id);
	}

}
