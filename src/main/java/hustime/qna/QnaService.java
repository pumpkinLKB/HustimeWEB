package hustime.qna;

import java.util.List;

public interface QnaService {
	
	public int selectNewBoardCount() throws Exception;
	
	List<QnaDto> selectTopFiveBoardList() throws Exception;
	
}
