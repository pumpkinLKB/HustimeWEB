package hustime.controller;

import javax.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hustime.member.configuration.auth.LoginUser;
import hustime.member.configuration.auth.dto.SessionUser;
import hustime.member.domain.user.User;
import lombok.RequiredArgsConstructor;

import hustime.community.schedule.service.ScheduleService;
import hustime.community.schedule.dto.*;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/1")
	public String index(Model model, @LoginUser SessionUser user) {
		return "index";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET) 
	public ModelAndView templateloginPage(Model model, @LoginUser SessionUser user) throws Exception{
		System.out.println("USER: "+user);
		if(user!=null) {
			model.addAttribute("userName", user.getName());
		}
		ModelAndView mv = new ModelAndView("/index1");
		List<ScheduleDto> list = scheduleService.selectBoardList();
		mv.addObject("list", list);
		return mv;
	}
	
}