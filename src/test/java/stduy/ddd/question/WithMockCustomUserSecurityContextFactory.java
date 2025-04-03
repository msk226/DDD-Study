package stduy.ddd.question;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import stduy.ddd.domain.user.UserPrincipal;

public class WithMockCustomUserSecurityContextFactory
        implements WithSecurityContextFactory<WithMockCustomUser> {

    @Override
    public SecurityContext createSecurityContext(WithMockCustomUser customUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        UserPrincipal principal = new UserPrincipal(1L, "email@email.com");
        Authentication auth = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
        context.setAuthentication(auth);
        return context;
    }
}
