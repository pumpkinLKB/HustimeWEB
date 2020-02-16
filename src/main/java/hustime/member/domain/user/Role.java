package hustime.member.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
	USER("ROLE_USER", "손님"),
    ADMIN("ROLE_ADMIN", "어드민");

    private final String key;
    private final String title;
}

