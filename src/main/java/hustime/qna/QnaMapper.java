package hustime.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hustime.qna.etc.dto.EtcDto;
import hustime.qna.tech.dto.TechDto;
import hustime.qna.tech.dto.TechFileDto;

@Mapper
public interface QnaMapper {
	
	int selectNewBoardCount() throws Exception;
	
	List<QnaDto> selectTopFiveBoardList() throws Exception;
	
}
