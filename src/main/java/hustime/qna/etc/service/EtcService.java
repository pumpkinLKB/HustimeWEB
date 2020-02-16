package hustime.qna.etc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.qna.etc.dto.EtcDto;
import hustime.qna.etc.dto.EtcFileDto;

public interface EtcService {
	
	List<EtcDto> selectBoardList() throws Exception;
	
	List<EtcDto> selectTopFiveBoardList() throws Exception;
	
	void insertBoard(EtcDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

	EtcDto selectBoardDetail(int boardIdx) throws Exception;

	void updateBoard(EtcDto board) throws Exception;

	void deleteBoard(int boardIdx) throws Exception;

	EtcFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception; 
}
