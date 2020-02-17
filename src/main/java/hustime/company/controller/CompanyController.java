package hustime.company.controller;

import java.io.IOException;

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
      
   @RequestMapping(value = "/company/aina")
   public ModelAndView openCompanyInfo1(@LoginUser SessionUser user){
	   ModelAndView mv = new ModelAndView("/company/aina");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   
   @RequestMapping(value = "/company/a2tec")
   public ModelAndView openCompanyInfo2(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/a2tec");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   
   @RequestMapping(value = "/company/avaco")
   public ModelAndView openCompanyInfo3(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/avaco");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/bumil")
   public ModelAndView openCompanyInfo4(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/bumil");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/computermate")
   public ModelAndView openCompanyInfo5(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/computermate");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/databank")
   public ModelAndView openCompanyInfo6(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/databank");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/digen")
   public ModelAndView openCompanyInfo7(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/digen");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/dongametal")
   public ModelAndView openCompanyInfo8(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/dongametal");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/emotion")
   public ModelAndView openCompanyInfo9(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/emotion");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/eroum")
   public ModelAndView openCompanyInfo10(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/eroum");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/forwiz")
   public ModelAndView openCompanyInfo11(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/forwiz");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/fusionsoft")
   public ModelAndView openCompanyInfo12(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/fusionsoft");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/hanait")
   public ModelAndView openCompanyInfo13(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/hanait");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/humanplus")
   public ModelAndView openCompanyInfo14(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/humanplus");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/igis")
   public ModelAndView openCompanyInfo15(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/igis");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/insung")
   public ModelAndView openCompanyInfo16(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/insung");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/itu")
   public ModelAndView openCompanyInfo17(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/itu");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/jeyunmedical")
   public ModelAndView openCompanyInfo18(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/jeyunmedical");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/jmon")
   public ModelAndView openCompanyInfo19(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/jmon");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/kpc")
   public ModelAndView openCompanyInfo20(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/kpc");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/myungsung")
   public ModelAndView openCompanyInfo21(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/myungsung");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/rayworld")
   public ModelAndView openCompanyInfo22(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/rayworld");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/rnu")
   public ModelAndView openCompanyInfo23(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/rnu");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/sillasystem")
   public ModelAndView openCompanyInfo24(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/sillasystem");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/theimc")
   public ModelAndView openCompanyInfo25(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/theimc");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/winitech")
   public ModelAndView openCompanyInfo26(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/winitech");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/wookyung")
   public ModelAndView openCompanyInfo27(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/wookyung");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   @RequestMapping(value = "/company/yhdatabase")
   public ModelAndView openCompanyInfo28(@LoginUser SessionUser user) throws IOException {
	   ModelAndView mv = new ModelAndView("/company/yhdatabase");
	   if(user!=null) {
           mv.addObject("uName", user.getName());
       }
	   return mv;
   }
   
}