package hustime.community.notice.dto;

import lombok.Data;

@Data
public class NoticeFileDto {

	private int idx;

	private int boardIdx;

	private String originalFileName;

	private String storedFilePath;

	private long fileSize;
}
