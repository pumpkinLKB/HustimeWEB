package hustime.community.notice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.community.notice.dto.NoticeDto;
import hustime.community.notice.dto.NoticeFileDto;

public interface NoticeService {
	
	List<NoticeDto> selectBoardList() throws Exception;
	
	List<NoticeDto> selectTopFiveBoardList() throws Exception;
	
	int selectNewBoardCount() throws Exception;
	
	void insertBoard(NoticeDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

	NoticeDto selectBoardDetail(int boardIdx) throws Exception;

	void updateBoard(NoticeDto board) throws Exception;

	void deleteBoard(int boardIdx) throws Exception;

	NoticeFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception; 
}
