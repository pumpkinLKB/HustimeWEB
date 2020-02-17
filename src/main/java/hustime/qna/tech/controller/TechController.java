package hustime.qna.tech.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import hustime.member.configuration.auth.LoginUser;
import hustime.member.configuration.auth.dto.SessionUser;
import hustime.qna.tech.dto.TechDto;
import hustime.qna.tech.dto.TechFileDto;
import hustime.qna.tech.service.TechService;

@Controller
public class TechController {

	@Autowired
	private TechService boardService;

	@RequestMapping(value = "/qna/tech", method = RequestMethod.GET)
	public ModelAndView openBoardList(@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/qna/tech/list");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		List<TechDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping(value = "/qna/tech/write", method = RequestMethod.GET)
	public ModelAndView openBoardWrite(@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/qna/tech/write");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		return mv;
	}

	@RequestMapping(value = "/qna/tech/write", method = RequestMethod.POST)
	public String insertBoard(TechDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardService.insertBoard(board, multipartHttpServletRequest);
		return "redirect:/qna/tech";
	}

	@RequestMapping(value = "/qna/tech/{boardIdx}", method = RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx, ModelMap model,
			@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/qna/tech/detail");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		TechDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}

	@RequestMapping(value = "/qna/tech/{boardIdx}", method = RequestMethod.POST)
	public ModelAndView openBoardEdit(@PathVariable("boardIdx") int boardIdx, ModelMap model,
			@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/qna/tech/edit");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		TechDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}

	@RequestMapping(value = "/qna/tech/{boardIdx}", method = RequestMethod.PUT)
	public String updateBoard(TechDto board) throws Exception {
		boardService.updateBoard(board);
		return "redirect:/qna/tech";
	}

	@RequestMapping(value = "/qna/tech/{boardIdx}", method = RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
		return "redirect:/qna/tech";
	}

	@RequestMapping(value = "/qna/tech/file", method = RequestMethod.GET)
	public void downloadBoardFile(@RequestParam int idx, @RequestParam int boardIdx, HttpServletResponse response)
			throws Exception {
		TechFileDto boardFile = boardService.selectBoardFileInformation(idx, boardIdx);
		if (ObjectUtils.isEmpty(boardFile) == false) {
			String fileName = boardFile.getOriginalFileName();

			byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));

			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);
			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");

			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
}
