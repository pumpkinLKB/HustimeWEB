package hustime.member.member.service;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hustime.member.member.entity.MemberEntity;
import hustime.member.member.repository.MemberRepository;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class MyUserService implements UserDetailsService{
	@Autowired
    MemberRepository memberRepository;

	private static final String ROLE_PREFIX = "ROLE_";

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("email : "+email);

		MemberEntity member = memberRepository.findByEmail(email);
		log.debug("member", member.toString());
		System.out.println("member : "+member.toString());
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + member.getRole().name()));
		log.debug("권한체크:", grantedAuthorities.toString());
		
		return new User(member.getEmail(), member.getPassword(), grantedAuthorities);
	}
}
