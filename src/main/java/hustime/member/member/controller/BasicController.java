package hustime.member.member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hustime.member.configuration.auth.LoginUser;
import hustime.member.configuration.auth.dto.SessionUser;
import hustime.member.member.entity.MemberEntity;
import hustime.member.member.entity.MemberRole;
import hustime.member.member.service.MemberService;
import hustime.member.member.service.MyUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
public class BasicController {	
//	@Autowired
//	private MemberService memberService;
//	
//	@Autowired
//	private MyUserService myUserService;
//	
//	@Autowired
//	private MemberValidator memberValidator;
	
//	@RequestMapping(value = "/hu_login", method=RequestMethod.GET) 
//	public String templateloginPage(Model model, @LoginUser SessionUser user) {
//		System.out.println("USER: "+user);
//		if(user!=null) {
//			model.addAttribute("userName", user.getName());
//		}
//		return "member/layout/login";
//	}
	
	//
//	@RequestMapping(value = "/register", method=RequestMethod.GET) 
//	public String registration(Model model) {
//		model.addAttribute("userForm", new MemberEntity());
//		return "/member/register"; 
//	}
//	
//	@RequestMapping(value = "/register", method=RequestMethod.POST) 
//	public String registration(@ModelAttribute("userForm") @Valid MemberEntity userForm, BindingResult bindingResult) {
//		memberValidator.validate(userForm, bindingResult);
//		
//		if(bindingResult.hasErrors()) {
//			log.debug("valid error");
//			return "register";
//		}
//		
//		userForm.setRole(MemberRole.USER);
//		memberService.save(userForm);
//		log.debug("userInfo" + userForm.toString());
//		log.debug("email" + userForm.getEmail() + "|" + userForm.getPassword());
//		return "/index"; 
//	}

}
