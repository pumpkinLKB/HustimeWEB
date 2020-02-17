package hustime.community.schedule.controller;

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

import hustime.community.schedule.dto.ScheduleDto;
import hustime.community.schedule.dto.ScheduleFileDto;
import hustime.community.schedule.service.ScheduleService;
import hustime.member.configuration.auth.LoginUser;
import hustime.member.configuration.auth.dto.SessionUser;
import hustime.member.member.controller.BasicController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService boardService;

	@RequestMapping(value = "/community/schedule", method = RequestMethod.GET)
	public ModelAndView openBoardList(@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/community/schedule/list");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		List<ScheduleDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping(value = "/community/schedule/write", method = RequestMethod.GET)
	public ModelAndView openBoardWrite(@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/community/schedule/write");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		return mv;
	}

	@RequestMapping(value = "/community/schedule/write", method = RequestMethod.POST)
	public String insertBoard(ScheduleDto board, MultipartHttpServletRequest multipartHttpServletRequest)
			throws Exception {
		boardService.insertBoard(board, multipartHttpServletRequest);
		return "redirect:/community/schedule";
	}

	@RequestMapping(value = "/community/schedule/{boardIdx}", method = RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx, ModelMap modem,
			@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/community/schedule/detail");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		ScheduleDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}

	@RequestMapping(value = "/community/schedule/{boardIdx}", method = RequestMethod.POST)
	public ModelAndView openBoardEdit(@PathVariable("boardIdx") int boardIdx, ModelMap model,
			@LoginUser SessionUser user) throws Exception {
		ModelAndView mv = new ModelAndView("/community/schedule/edit");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		ScheduleDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}

	@RequestMapping(value = "/community/schedule/{boardIdx}", method = RequestMethod.PUT)
	public String updateBoard(ScheduleDto board) throws Exception {
		boardService.updateBoard(board);
		System.out.println("@@@@@@@@@@@@");
		System.out.println(board);
		return "redirect:/community/schedule";
	}

	@RequestMapping(value = "/community/schedule/{boardIdx}", method = RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
		return "redirect:/community/schedule";
	}

	@RequestMapping(value = "/community/schedule/file", method = RequestMethod.GET)
	public void downloadBoardFile(@RequestParam int idx, @RequestParam int boardIdx, HttpServletResponse response)
			throws Exception {
		ScheduleFileDto boardFile = boardService.selectBoardFileInformation(idx, boardIdx);
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
