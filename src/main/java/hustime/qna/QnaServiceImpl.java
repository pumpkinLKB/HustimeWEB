package hustime.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaServiceImpl implements QnaService{
	
	
	@Autowired
	private QnaMapper boardMapper;
	
	@Override
	public int selectNewBoardCount() throws Exception{
		return boardMapper.selectNewBoardCount();
	}
	
	@Override
	public List<QnaDto> selectTopFiveBoardList() throws Exception {
		return boardMapper.selectTopFiveBoardList();
	}
}

