package hustime.member.member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hustime.member.member.entity.MemberEntity;
import hustime.member.member.entity.MemberRole;
import hustime.member.member.service.MemberService;
import hustime.member.support.MemberValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BasicController {	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberValidator memberValidator;

	@RequestMapping(value = "/hu_login", method=RequestMethod.GET) 
	public String templateloginPage(Model model) {
		model.addAttribute("userForm", new MemberEntity());
		return "/member/hu_login"; 
	}
	
	@RequestMapping(value = "/lostPwd")
	public String templatepasswordPage(Model model) {
		return "/member/password"; 
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET) 
	public String registration(Model model) {
		model.addAttribute("userForm", new MemberEntity());
		//log.debug("#####22");
		return "/member/register"; 
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST) 
	public String registration(@ModelAttribute("userForm") @Valid MemberEntity userForm, BindingResult bindingResult) {
		memberValidator.validate(userForm, bindingResult);
		//log.debug("#####");
		
		if(bindingResult.hasErrors()) {
			log.debug("valid error");
			return "signup";
		}
		
		userForm.setRole(MemberRole.USER);
		memberService.save(userForm);
		return "/index"; 
	}

}
