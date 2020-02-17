package hustime.qna.tech.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.qna.tech.dto.TechDto;
import hustime.qna.tech.dto.TechFileDto;

public interface TechService {
	
	List<TechDto> selectBoardList() throws Exception;
	
	List<TechDto> selectTopFiveBoardList() throws Exception;
	
	void insertBoard(TechDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

	TechDto selectBoardDetail(int boardIdx) throws Exception;

	void updateBoard(TechDto board) throws Exception;

	void deleteBoard(int boardIdx) throws Exception;

	TechFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception; 
}
