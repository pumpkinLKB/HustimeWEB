package hustime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
import hustime.community.schedule.service.ScheduleService;
import hustime.community.schedule.dto.*;
=======
import hustime.community.notice.dto.NoticeDto;
import hustime.community.notice.service.NoticeService;
import hustime.community.schedule.dto.ScheduleDto;
import hustime.community.schedule.service.ScheduleService;
import hustime.member.configuration.auth.LoginUser;
import hustime.member.configuration.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
>>>>>>> refs/remotes/origin/master
@Controller
public class IndexController {
<<<<<<< HEAD
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView openBoardList(ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/index");
		List<ScheduleDto> list = scheduleService.selectBoardList();
		mv.addObject("list", list);
		return mv;
	}
	
=======
   
   @Autowired
   private ScheduleService scheduleService;
   @Autowired
   private NoticeService noticeService;
   
//   @GetMapping("/1")
//   public String index(Model model, @LoginUser SessionUser user) {
//      return "index";
//   }
   
   @RequestMapping(value = "/", method=RequestMethod.GET) 
   public ModelAndView templateloginPage(Model model, @LoginUser SessionUser user) throws Exception{
      System.out.println("USER: "+user);
      if(user!=null) {
         model.addAttribute("uName", user.getName());
      }
      ModelAndView mv = new ModelAndView("/index");
      if(user!=null) {
          mv.addObject("uName", user.getName());
       }
      List<ScheduleDto> list_schedule = scheduleService.selectTopFiveBoardList();
      List<NoticeDto> list_notice = noticeService.selectTopFiveBoardList();
      mv.addObject("list_schedule", list_schedule);
      mv.addObject("list_notice", list_notice);
      return mv;
   }
   
>>>>>>> refs/remotes/origin/master
}