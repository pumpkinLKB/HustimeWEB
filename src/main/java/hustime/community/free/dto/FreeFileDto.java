package hustime.community.free.dto;

import lombok.Data;

@Data
public class FreeFileDto {

	private int idx;

	private int boardIdx;

	private String originalFileName;

	private String storedFilePath;

	private long fileSize;
}
