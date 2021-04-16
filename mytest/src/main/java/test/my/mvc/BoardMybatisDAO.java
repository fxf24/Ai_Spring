package test.my.mvc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class BoardMybatisDAO {
	@Autowired
	SqlSession session;

	public List<BoardDTO> getBoardList() {
		// TODO Auto-generated method stub
		return session.selectList("board.list");
	}
	
	public BoardDTO getBoardDetail(int seq) {
		session.update("board.upview", seq);
		return session.selectOne("board.oneview", seq);
	}
}
