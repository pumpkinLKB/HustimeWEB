package hustime.qna.etc.controller;

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
import hustime.qna.etc.dto.EtcDto;
import hustime.qna.etc.dto.EtcFileDto;
import hustime.qna.etc.service.EtcService;

@Controller
public class EtcController {

	@Autowired
	private EtcService boardService;

	@RequestMapping(value = "/qna/etc", method = RequestMethod.GET)
	public ModelAndView openBoardList(@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/qna/etc/list");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		List<EtcDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping(value = "/qna/etc/write", method = RequestMethod.GET)
	public ModelAndView openBoardWrite(@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/qna/etc/write");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		return mv;
	}

	@RequestMapping(value = "/qna/etc/write", method = RequestMethod.POST)
	public String insertBoard(EtcDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardService.insertBoard(board, multipartHttpServletRequest);
		return "redirect:/qna/etc";
	}

	@RequestMapping(value = "/qna/etc/{boardIdx}", method = RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx, ModelMap model,
			@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/qna/etc/detail");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		EtcDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}

	@RequestMapping(value = "/qna/etc/{boardIdx}", method = RequestMethod.POST)
	public ModelAndView openBoardEdit(@PathVariable("boardIdx") int boardIdx, ModelMap model,
			@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/qna/etc/edit");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		EtcDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}

	@RequestMapping(value = "/qna/etc/{boardIdx}", method = RequestMethod.PUT)
	public String updateBoard(EtcDto board) throws Exception {
		boardService.updateBoard(board);
		return "redirect:/qna/etc";
	}

	@RequestMapping(value = "/qna/etc/{boardIdx}", method = RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
		return "redirect:/qna/etc";
	}

	@RequestMapping(value = "/qna/etc/file", method = RequestMethod.GET)
	public void downloadBoardFile(@RequestParam int idx, @RequestParam int boardIdx, HttpServletResponse response)
			throws Exception {
		EtcFileDto boardFile = boardService.selectBoardFileInformation(idx, boardIdx);
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
