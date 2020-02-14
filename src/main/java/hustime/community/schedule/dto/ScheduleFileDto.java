package hustime.community.schedule.dto;

import lombok.Data;

@Data
public class ScheduleFileDto {

	private int idx;

	private int boardIdx;

	private String originalFileName;

	private String storedFilePath;

	private long fileSize;
}
