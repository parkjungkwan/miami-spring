package fastcode.api.cop.adm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.lms.dwh.domain.Page;
import com.bitcamp.lms.qna.domain.Quiz;
import com.bitcamp.lms.qna.service.QuizService;


import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Service
public class CopQueServiceImpl implements QuizService{

	@Override
	public int save(Quiz param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Quiz param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Quiz param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Quiz> findAll(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quiz getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
