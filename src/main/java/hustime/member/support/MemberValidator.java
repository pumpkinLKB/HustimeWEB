package hustime.member.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import hustime.member.member.entity.MemberEntity;
import hustime.member.member.service.MemberService;

// 회원가입 입력값 검증
@Component
public class MemberValidator implements Validator{
	@Autowired
	private MemberService memberService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberEntity.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		MemberEntity member= (MemberEntity)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if(member.getUsername().length() < 3 || member.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
				
		if(memberService.findByUserEmail(member.getEmail())!=null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
	}
}
