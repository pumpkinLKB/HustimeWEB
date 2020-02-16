package hustime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hustime.community.free.dto.FreeDto;
import hustime.community.free.service.FreeService;
import hustime.community.notice.dto.NoticeDto;
import hustime.community.notice.service.NoticeService;
import hustime.community.schedule.dto.ScheduleDto;
import hustime.community.schedule.service.ScheduleService;
import hustime.member.configuration.auth.LoginUser;
import hustime.member.configuration.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
   
   @Autowired
   private ScheduleService scheduleService;
   @Autowired
   private NoticeService noticeService;
   @Autowired
   private FreeService freeService;
   
   @RequestMapping(value = "/", method=RequestMethod.GET) 
   public ModelAndView templateloginPage(Model model, @LoginUser SessionUser user) throws Exception{
      System.out.println("USER: "+user);
      ModelAndView mv = new ModelAndView("/index");
      if(user!=null) {
          mv.addObject("uName", user.getName());
       }
      List<ScheduleDto> list_schedule = scheduleService.selectTopFiveBoardList();
      List<NoticeDto> list_notice = noticeService.selectTopFiveBoardList();
      List<FreeDto> list_free = freeService.selectTopFiveBoardList();
      mv.addObject("list_schedule", list_schedule);
      mv.addObject("list_notice", list_notice);
      mv.addObject("list_free", list_free);
      return mv;
   }
   
}
