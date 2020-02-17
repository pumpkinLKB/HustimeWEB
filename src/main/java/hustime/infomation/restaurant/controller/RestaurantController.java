package hustime.infomation.restaurant.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hustime.community.schedule.dto.ScheduleDto;
import hustime.member.configuration.auth.LoginUser;
import hustime.member.configuration.auth.dto.SessionUser;

@Controller
public class RestaurantController {
	
	@RequestMapping(value="/infomation/restaurant", method=RequestMethod.GET)
	public ModelAndView openBoardWrite(@LoginUser SessionUser user) throws Exception{
		ModelAndView mv = new ModelAndView("/infomation/restaurant/map");
		if (user != null) {
			mv.addObject("uName", user.getName());
		}
		return mv;
	}
}
