package hustime.community.free.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hustime.community.free.dto.FreeDto;
import hustime.community.free.dto.FreeFileDto;

@Mapper
public interface FreeMapper {

	List<FreeDto> selectBoardList() throws Exception;
	
	List<FreeDto> selectTopFiveBoardList() throws Exception;
	
	void insertBoard(FreeDto board) throws Exception;

	FreeDto selectBoardDetail(int boardIdx) throws Exception;

	void updateHitCount(int boardIdx) throws Exception;
	
	void updateBoard(FreeDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;

	void insertBoardFileList(List<FreeFileDto> list) throws Exception;

	List<FreeFileDto> selectBoardFileList(int boardIdx) throws Exception;

	FreeFileDto selectBoardFileInformation(@Param("idx") int idx, @Param("boardIdx" )int boardIdx);
	
}
