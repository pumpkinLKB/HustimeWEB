package hustime.community.schedule.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.community.schedule.dto.ScheduleDto;
import hustime.community.schedule.dto.ScheduleFileDto;

public interface ScheduleService {
	
	List<ScheduleDto> selectBoardList() throws Exception;
	
	void insertBoard(ScheduleDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

	ScheduleDto selectBoardDetail(int boardIdx) throws Exception;

	void updateBoard(ScheduleDto board) throws Exception;

	void deleteBoard(int boardIdx) throws Exception;

	ScheduleFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception; 
}
