package hustime.community.free.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.community.free.dto.FreeDto;
import hustime.community.free.dto.FreeFileDto;

public interface FreeService {
	
	List<FreeDto> selectBoardList() throws Exception;
	
	List<FreeDto> selectTopFiveBoardList() throws Exception;
	
	void insertBoard(FreeDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

	FreeDto selectBoardDetail(int boardIdx) throws Exception;

	void updateBoard(FreeDto board) throws Exception;

	void deleteBoard(int boardIdx) throws Exception;

	FreeFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception; 
}
