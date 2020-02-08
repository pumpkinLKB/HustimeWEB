package hustime.community.schedule.dto;

import java.util.List;

import lombok.Data;

@Data
public class ScheduleDto {
	
	private int boardIdx;
	
	private String title;
	
	private String contents;
	
	private int hitCnt;
	
	private String creatorId;
	
	private String createdDatetime;
	
	private String updaterId;
	
	private String updatedDatetime;
	
	private List<ScheduleFileDto> fileList;
}
