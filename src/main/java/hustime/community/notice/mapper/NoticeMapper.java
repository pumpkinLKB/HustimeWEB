package hustime.community.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hustime.community.notice.dto.NoticeDto;
import hustime.community.notice.dto.NoticeFileDto;

@Mapper
public interface NoticeMapper {

	List<NoticeDto> selectBoardList() throws Exception;
	
	List<NoticeDto> selectTopFiveBoardList() throws Exception;
	
	void insertBoard(NoticeDto board) throws Exception;

	NoticeDto selectBoardDetail(int boardIdx) throws Exception;

	void updateHitCount(int boardIdx) throws Exception;
	
	void updateBoard(NoticeDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;

	void insertBoardFileList(List<NoticeFileDto> list) throws Exception;

	List<NoticeFileDto> selectBoardFileList(int boardIdx) throws Exception;

	NoticeFileDto selectBoardFileInformation(@Param("idx") int idx, @Param("boardIdx" )int boardIdx);
	
}
