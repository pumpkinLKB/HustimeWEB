package hustime.member.member.service;

import hustime.member.member.entity.MemberEntity;

public interface MemberService {
	void save(MemberEntity member);
	
	MemberEntity findByUserEmail(String email);
}
