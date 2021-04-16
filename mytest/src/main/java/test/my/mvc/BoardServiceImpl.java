package test.my.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMybatisDAO dao;

	@Override
	public List<BoardDTO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public BoardDTO getBoardDetail(int seq) {
		// TODO Auto-generated method stub
		return dao.getBoardDetail(seq);
	}
	
	
}
