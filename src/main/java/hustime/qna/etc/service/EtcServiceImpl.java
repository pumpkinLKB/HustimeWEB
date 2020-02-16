package hustime.qna.etc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.qna.etc.common.EtcFileUtils;
import hustime.qna.etc.dto.EtcDto;
import hustime.qna.etc.dto.EtcFileDto;
import hustime.qna.etc.mapper.EtcMapper;

@Service
public class EtcServiceImpl implements EtcService{
	
	
	@Autowired
	private EtcMapper boardMapper;
	
	@Autowired
	private EtcFileUtils fileUtils;
	
	@Override
	public List<EtcDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	
	@Override
	public List<EtcDto> selectTopFiveBoardList() throws Exception {
		return boardMapper.selectTopFiveBoardList();
	}
	
	@Override
	public void insertBoard(EtcDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardMapper.insertBoard(board);
		List<EtcFileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list) == false){
			boardMapper.insertBoardFileList(list);
		}
	}

	@Override
	public EtcDto selectBoardDetail(int boardIdx) throws Exception{
		EtcDto board = boardMapper.selectBoardDetail(boardIdx);
		List<EtcFileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(fileList);
		
		boardMapper.updateHitCount(boardIdx);
		
		return board;
	}
	
	@Override
	public void updateBoard(EtcDto board) throws Exception {
		boardMapper.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}
	
	@Override
	public EtcFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception {
		return boardMapper.selectBoardFileInformation(idx, boardIdx);
	}
}

