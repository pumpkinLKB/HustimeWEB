package hustime.qna.etc.dto;

import lombok.Data;

@Data
public class EtcFileDto {

	private int idx;

	private int boardIdx;

	private String originalFileName;

	private String storedFilePath;

	private long fileSize;
}
