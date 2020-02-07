package hustime.community.notice.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import hustime.community.notice.dto.NoticeDto;
import hustime.community.notice.dto.NoticeFileDto;
import hustime.community.notice.service.NoticeService;
import hustime.member.member.controller.BasicController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService boardService;
	
	@RequestMapping(value="/community/notice", method=RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/community/notice/list");
		List<NoticeDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		return mv;
	}
	
	
	@RequestMapping(value="/community/notice/write", method=RequestMethod.GET)
	public String openBoardWrite() throws Exception{
		return "/community/notice/write";
	}

	@RequestMapping(value="/community/notice/write", method=RequestMethod.POST)
	public String insertBoard(NoticeDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		boardService.insertBoard(board, multipartHttpServletRequest);
		return "redirect:/community/notice";
	}
	
	@RequestMapping(value="/community/notice/{boardIdx}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx, ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/community/notice/detail");
		NoticeDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}
	
	@RequestMapping(value="/community/notice/{boardIdx}", method=RequestMethod.PUT)
	public String updateBoard(NoticeDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/community/notice";
	}
	
	@RequestMapping(value="/community/notice/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/community/notice";
	}
	
	@RequestMapping(value="/community/notice/file", method=RequestMethod.GET)
	public void downloadBoardFile(@RequestParam int idx, @RequestParam int boardIdx, HttpServletResponse response) throws Exception{
		NoticeFileDto boardFile = boardService.selectBoardFileInformation(idx, boardIdx);
		if(ObjectUtils.isEmpty(boardFile) == false) {
			String fileName = boardFile.getOriginalFileName();
			
			byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName,"UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
}
