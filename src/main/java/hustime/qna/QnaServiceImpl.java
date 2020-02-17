package hustime.qna;

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
}

