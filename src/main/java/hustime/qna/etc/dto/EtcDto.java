package hustime.qna.etc.dto;

import java.util.List;

import lombok.Data;

@Data
public class EtcDto {
	
	private int boardIdx;
	
	private String title;
	
	private String contents;
	
	private int hitCnt;
	
	private String creatorId;
	
	private String createdDatetime;
	
	private String updaterId;
	
	private String updatedDatetime;
	
	private List<EtcFileDto> fileList;
}
