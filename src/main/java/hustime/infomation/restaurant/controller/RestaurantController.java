package hustime.infomation.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestaurantController {
	
	@RequestMapping(value="/infomation/restaurant", method=RequestMethod.GET)
	public String openBoardWrite() throws Exception{
		return "/infomation/restaurant/map";
	}
}
