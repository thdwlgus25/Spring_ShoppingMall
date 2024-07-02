package inhatc.spring.shop.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();// 인증 정보 가져오기
        String userId = "";
        if(authentication != null) {
            userId = authentication.getName();
        }

        return Optional.of(userId);
    }
}
