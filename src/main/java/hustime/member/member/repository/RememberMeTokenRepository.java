package hustime.member.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hustime.member.member.entity.RememberMeToken;

import java.util.List;

@Repository
public interface RememberMeTokenRepository extends JpaRepository<RememberMeToken, String>{
    RememberMeToken findBySeries(String series);
    List<RememberMeToken> findByUsername(String username);
}
