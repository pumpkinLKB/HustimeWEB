package hustime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hustime.community.schedule.service.ScheduleService;
import hustime.community.schedule.dto.*;
@Controller
public class IndexController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView openBoardList(ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/index");
		List<ScheduleDto> list = scheduleService.selectBoardList();
		mv.addObject("list", list);
		return mv;
	}
	
}