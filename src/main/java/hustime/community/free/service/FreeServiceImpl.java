package hustime.community.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.community.free.common.FreeFileUtils;
import hustime.community.free.dto.FreeDto;
import hustime.community.free.dto.FreeFileDto;
import hustime.community.free.mapper.FreeMapper;

@Service
public class FreeServiceImpl implements FreeService{
	
	
	@Autowired
	private FreeMapper boardMapper;
	
	@Autowired
	private FreeFileUtils fileUtils;
	
	@Override
	public List<FreeDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	
	@Override
	public List<FreeDto> selectTopFiveBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	
	@Override
	public void insertBoard(FreeDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardMapper.insertBoard(board);
		List<FreeFileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list) == false){
			boardMapper.insertBoardFileList(list);
		}
	}

	@Override
	public FreeDto selectBoardDetail(int boardIdx) throws Exception{
		FreeDto board = boardMapper.selectBoardDetail(boardIdx);
		List<FreeFileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(fileList);
		
		boardMapper.updateHitCount(boardIdx);
		
		return board;
	}
	
	@Override
	public void updateBoard(FreeDto board) throws Exception {
		boardMapper.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}
	
	@Override
	public FreeFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception {
		return boardMapper.selectBoardFileInformation(idx, boardIdx);
	}
}

