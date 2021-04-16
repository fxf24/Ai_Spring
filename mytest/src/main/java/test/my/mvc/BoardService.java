package test.my.mvc;

import java.util.List;

public interface BoardService {

	List<BoardDTO> getBoardList();
	BoardDTO getBoardDetail(int seq);
}
