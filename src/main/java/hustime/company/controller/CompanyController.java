package hustime.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hustime.member.configuration.auth.LoginUser;
import hustime.member.configuration.auth.dto.SessionUser;

@Controller
public class CompanyController {
   @RequestMapping(value = "/company")
   public ModelAndView openCompanyList(@LoginUser SessionUser user) {
      ModelAndView mv = new ModelAndView("/company/list");
      if(user!=null) {
           mv.addObject("uName", user.getName());
       }
      return mv;
   }
}