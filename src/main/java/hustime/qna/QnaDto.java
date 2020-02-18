package hustime.qna;

import java.util.List;

import lombok.Data;

@Data
public class QnaDto {
	
	private int boardIdx;
	
	private String title;
	
	private String contents;
	
	private int hitCnt;
	
	private String creatorId;
	
	private String createdDatetime;
	
	private String updaterId;
	
	private String updatedDatetime;
	
	private List<QnaFileDto> fileList;
}
