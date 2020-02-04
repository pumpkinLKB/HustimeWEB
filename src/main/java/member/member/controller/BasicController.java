package member.member.controller;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PropertySource("application.properties")
public class BasicController {	
	@RequestMapping(value = "/")
	public String templateRootPage() {
		return "index"; 
	}
	
	@RequestMapping(value = "/index") 
	public String templateIndexPage(Model model) {
		return "index"; 
	}
	
	@RequestMapping(value = "/401") 
	public String template401Page(Model model) {
		return "401"; 
	}
	
	@RequestMapping(value = "/404") 
	public String template404Page(Model model) {
		return "404"; 
	}
	
	@RequestMapping(value = "/405") 
	public String template405Page(Model model) {
		return "405"; 
	}
	
	@RequestMapping(value = "/layout2") // 왼쪽 메뉴바 검정색
	public String templatelayout2Page(Model model) {
		return "layout-static"; 
	}
	
	@RequestMapping(value = "/login") 
	public String templateloginPage(Model model) {
		return "login"; 
	}
	
	@RequestMapping(value = "/password")
	public String templatepasswordPage(Model model) {
		return "password"; 
	}
	
	@RequestMapping(value = "/register") 
	public String templateregisterPage(Model model) {
		return "register"; 
	}
	
	@RequestMapping(value = "/tables") // 말그대로 테이블 형태로 보여줌
	public String templatetablesPage(Model model) {
		return "tables"; 
	}
	
	@RequestMapping(value = "/calendar")
	public String templateCalendarPage(Model model) {
		return "Calendar"; 
	}
}
