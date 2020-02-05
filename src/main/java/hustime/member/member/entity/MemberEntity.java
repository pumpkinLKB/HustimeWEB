package hustime.member.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="member")
@NoArgsConstructor
@Data
public class MemberEntity {	
	@Id
	@Column(nullable=false)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String passwordConfirm;
	
	@Column(nullable=false)
	private String email;
	
	@Column(name = "role_name")
	@Enumerated(EnumType.STRING)
	private MemberRole role;
}
