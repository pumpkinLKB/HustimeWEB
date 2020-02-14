package hustime.community.free.controller;

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

import hustime.community.free.dto.FreeDto;
import hustime.community.free.dto.FreeFileDto;
import hustime.community.free.service.FreeService;
import hustime.member.member.controller.BasicController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class FreeController {
	
	@Autowired
	private FreeService boardService;
	
	@RequestMapping(value="/community/free", method=RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/community/free/list");
		List<FreeDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		return mv;
	}
	
	
	@RequestMapping(value="/community/free/write", method=RequestMethod.GET)
	public String openBoardWrite() throws Exception{
		return "/community/free/write";
	}

	@RequestMapping(value="/community/free/write", method=RequestMethod.POST)
	public String insertBoard(FreeDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		boardService.insertBoard(board, multipartHttpServletRequest);
		return "redirect:/community/free";
	}
	
	@RequestMapping(value="/community/free/{boardIdx}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx, ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/community/free/detail");
		FreeDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}
	
	@RequestMapping(value="/community/free/{boardIdx}", method=RequestMethod.POST)
	public ModelAndView openBoardEdit(@PathVariable("boardIdx") int boardIdx, ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/community/free/edit");
		FreeDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}
	
	@RequestMapping(value="/community/free/{boardIdx}", method=RequestMethod.PUT)
	public String updateBoard(FreeDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/community/free";
	}
	
	@RequestMapping(value="/community/free/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/community/free";
	}
	
	@RequestMapping(value="/community/free/file", method=RequestMethod.GET)
	public void downloadBoardFile(@RequestParam int idx, @RequestParam int boardIdx, HttpServletResponse response) throws Exception{
		FreeFileDto boardFile = boardService.selectBoardFileInformation(idx, boardIdx);
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
