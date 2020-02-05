package hustime.member.member.service;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Slf4j
@Component
public class MemberAccessDeniedHandler implements AccessDeniedHandler{
	@Override
	public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException accessDeniedException) throws IOException, ServletException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			log.info("User '"+auth.getName()+"' attempted to access the protected URL: "+req.getRequestURI());
		}
		
		res.sendRedirect(req.getContextPath()+"/403");
	}
}
