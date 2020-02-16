package hustime.qna.etc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hustime.qna.etc.dto.EtcDto;
import hustime.qna.etc.dto.EtcFileDto;

@Mapper
public interface EtcMapper {

	List<EtcDto> selectBoardList() throws Exception;
	
	List<EtcDto> selectTopFiveBoardList() throws Exception;
	
	void insertBoard(EtcDto board) throws Exception;

	EtcDto selectBoardDetail(int boardIdx) throws Exception;

	void updateHitCount(int boardIdx) throws Exception;
	
	void updateBoard(EtcDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;

	void insertBoardFileList(List<EtcFileDto> list) throws Exception;

	List<EtcFileDto> selectBoardFileList(int boardIdx) throws Exception;

	EtcFileDto selectBoardFileInformation(@Param("idx") int idx, @Param("boardIdx" )int boardIdx);
	
}
