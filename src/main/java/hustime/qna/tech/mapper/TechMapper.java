package hustime.qna.tech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hustime.qna.tech.dto.TechDto;
import hustime.qna.tech.dto.TechFileDto;

@Mapper
public interface TechMapper {

	List<TechDto> selectBoardList() throws Exception;
	
	List<TechDto> selectTopFiveBoardList() throws Exception;
	
	void insertBoard(TechDto board) throws Exception;

	TechDto selectBoardDetail(int boardIdx) throws Exception;

	void updateHitCount(int boardIdx) throws Exception;
	
	void updateBoard(TechDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;

	void insertBoardFileList(List<TechFileDto> list) throws Exception;

	List<TechFileDto> selectBoardFileList(int boardIdx) throws Exception;

	TechFileDto selectBoardFileInformation(@Param("idx") int idx, @Param("boardIdx" )int boardIdx);
	
}
