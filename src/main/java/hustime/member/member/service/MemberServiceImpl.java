package hustime.member.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hustime.member.member.entity.MemberEntity;
import hustime.member.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memberRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public MemberEntity findByUserEmail(String email) {
		return memberRepository.findByEmail(email);
	}
	
	@Override
	public MemberEntity findByUserName(String username) {
		return memberRepository.findByUsername(username);
	}
		
//	/bCryptPasswordEncoder 는 단방향 암호화 클래스
//	@Override
//	public void save(MemberEntity member) {
//		member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
//		member.setPasswordConfirm(bCryptPasswordEncoder.encode(member.getPasswordConfirm()));
//		memberRepository.save(member);
//	}
}
