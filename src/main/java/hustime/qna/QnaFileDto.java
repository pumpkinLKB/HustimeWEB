package hustime.qna;

import lombok.Data;

@Data
public class QnaFileDto {

	private int idx;

	private int boardIdx;

	private String originalFileName;

	private String storedFilePath;

	private long fileSize;
}
