package FastFoodShop.FastFood.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException,
            ServletException {

        // get header jwt
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);

        // check valid token
        if(token != null && jwtTokenProvider.validateToken(token)) {
            // if token is valid -> get user info
            Authentication authentication = jwtTokenProvider.getAuthentication(token);

            // SecurityContextHolder -> save authentication entity
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}