package hustime.member.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hustime.member.member.entity.MemberEntity;

@Mapper
public interface MemberMapper {
	
	List<MemberEntity> selectUserInfoAll() throws Exception;
	
	void addUserInfo(MemberEntity member) throws Exception;
	
	MemberEntity findByUserName(String username) throws Exception;
	
	MemberEntity findByUserEmail(String email) throws Exception;
}
