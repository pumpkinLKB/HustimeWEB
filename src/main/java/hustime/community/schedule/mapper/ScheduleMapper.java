package hustime.community.schedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hustime.community.schedule.dto.ScheduleDto;
import hustime.community.schedule.dto.ScheduleFileDto;

@Mapper
public interface ScheduleMapper {

	List<ScheduleDto> selectBoardList() throws Exception;
	
	List<ScheduleDto> selectTopFiveBoardList() throws Exception;
	
	void insertBoard(ScheduleDto board) throws Exception;

	ScheduleDto selectBoardDetail(int boardIdx) throws Exception;

	void updateHitCount(int boardIdx) throws Exception;
	
	void updateBoard(ScheduleDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;

	void insertBoardFileList(List<ScheduleFileDto> list) throws Exception;

	List<ScheduleFileDto> selectBoardFileList(int boardIdx) throws Exception;

	ScheduleFileDto selectBoardFileInformation(@Param("idx") int idx, @Param("boardIdx" )int boardIdx);
	
}
