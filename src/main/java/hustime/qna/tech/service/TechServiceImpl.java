package hustime.qna.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.qna.tech.common.TechFileUtils;
import hustime.qna.tech.dto.TechDto;
import hustime.qna.tech.dto.TechFileDto;
import hustime.qna.tech.mapper.TechMapper;

@Service
public class TechServiceImpl implements TechService{
	
	
	@Autowired
	private TechMapper boardMapper;
	
	@Autowired
	private TechFileUtils fileUtils;
	
	@Override
	public List<TechDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	
	@Override
	public List<TechDto> selectTopFiveBoardList() throws Exception {
		return boardMapper.selectTopFiveBoardList();
	}
	
	@Override
	public void insertBoard(TechDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardMapper.insertBoard(board);
		List<TechFileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list) == false){
			boardMapper.insertBoardFileList(list);
		}
	}

	@Override
	public TechDto selectBoardDetail(int boardIdx) throws Exception{
		TechDto board = boardMapper.selectBoardDetail(boardIdx);
		List<TechFileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(fileList);
		
		boardMapper.updateHitCount(boardIdx);
		
		return board;
	}
	
	@Override
	public void updateBoard(TechDto board) throws Exception {
		boardMapper.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}
	
	@Override
	public TechFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception {
		return boardMapper.selectBoardFileInformation(idx, boardIdx);
	}
}

