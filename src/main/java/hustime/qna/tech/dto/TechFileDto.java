package hustime.qna.tech.dto;

import lombok.Data;

@Data
public class TechFileDto {

	private int idx;

	private int boardIdx;

	private String originalFileName;

	private String storedFilePath;

	private long fileSize;
}
