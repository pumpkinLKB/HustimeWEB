package hustime.community.chat.dto;

import java.util.List;

import hustime.community.free.dto.FreeDto;
import hustime.community.free.dto.FreeFileDto;
import lombok.Data;

@Data
public class ChatMessage {
	// 메시지 타입 : 입장, 채팅
	public enum MessageType {
		JOIN, ENTER, TALK
	}

	private MessageType type; // 메시지 타입
	private String roomId; // 방번호
	private String sender; // 메시지 보낸사람
	private String message; // 메시지
}
