package cs.miu.cs544.team2.filter;

import cs.miu.cs544.team2.Model.object.LoginUserDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private cs.miu.cs544.team2.util.JWTUtil jwtUtil;

    @Autowired
    private LoginUserDetail userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println("doFilterInternal");

        String authorization = httpServletRequest.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorization != null && authorization.startsWith("Bearer ")){
            jwt = authorization.substring(7);
            username = cs.miu.cs544.team2.util.JWTUtil.getUsernameFromToken(jwt);
            UserDetails userDetails = ((UserDetailsService) userDetailsService).loadUserByUsername(username);
            if (jwtUtil.validateToken(jwt, userDetails)){

                System.out.println(userDetails.getAuthorities());
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, userDetails, userDetails.getAuthorities());

                //authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
