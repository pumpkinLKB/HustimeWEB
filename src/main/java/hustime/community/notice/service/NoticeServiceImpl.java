package hustime.community.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.community.notice.common.NoticeFileUtils;
import hustime.community.notice.dto.NoticeDto;
import hustime.community.notice.dto.NoticeFileDto;
import hustime.community.notice.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	
	@Autowired
	private NoticeMapper boardMapper;
	
	@Autowired
	private NoticeFileUtils fileUtils;
	
	@Override
	public List<NoticeDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	
	@Override
	public void insertBoard(NoticeDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardMapper.insertBoard(board);
		List<NoticeFileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list) == false){
			boardMapper.insertBoardFileList(list);
		}
	}

	@Override
	public NoticeDto selectBoardDetail(int boardIdx) throws Exception{
		NoticeDto board = boardMapper.selectBoardDetail(boardIdx);
		List<NoticeFileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(fileList);
		
		boardMapper.updateHitCount(boardIdx);
		
		return board;
	}
	
	@Override
	public void updateBoard(NoticeDto board) throws Exception {
		boardMapper.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}
	
	@Override
	public NoticeFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception {
		return boardMapper.selectBoardFileInformation(idx, boardIdx);
	}
}

