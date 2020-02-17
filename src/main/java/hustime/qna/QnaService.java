package hustime.qna;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import hustime.qna.tech.dto.TechDto;
import hustime.qna.tech.dto.TechFileDto;

public interface QnaService {
	
	public int selectNewBoardCount() throws Exception;
	
}
