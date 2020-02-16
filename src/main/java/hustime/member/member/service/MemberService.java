package hustime.member.member.service;

import hustime.member.member.entity.MemberEntity;

public interface MemberService {
	//void save(MemberEntity member);
	
	MemberEntity findByUserName(String username);
	MemberEntity findByUserEmail(String email);
}
