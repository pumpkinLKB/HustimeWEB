package hustime.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomErrorController implements ErrorController{
	private static final String ERROR_PATH = "/error";
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		String status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)+"";
		HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));
		log.info("httpStatus : "+httpStatus.toString());
		switch(status) {
			case "401" : return "error/401";
			case "404" : return "error/404";
			case "500" : return "error/500";
			default : return "error/500";
		}
	}
}
