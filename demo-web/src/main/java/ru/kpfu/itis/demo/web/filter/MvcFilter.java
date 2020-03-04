package ru.kpfu.itis.demo.web.filter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.kpfu.itis.demo.web.User;
import ru.kpfu.itis.demo.web.jpa.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MvcFilter extends GenericFilterBean {
    private final UserRepository repository;

    public MvcFilter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        ((HttpServletRequest) servletRequest).getParameter("login")
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getRequestURI().equals("")){
            String authorization = request.getHeader("Authorization");
            String decoded = new String(Base64.decodeBase64(authorization));
            String[] split = decoded.split(":");
            User byUsername = repository.findByUsername(split[0]);
            if (Base64.encodeBase64String(("username:" + DigestUtils.md5Hex(byUsername.getUsername() + ":" + byUsername.getPass() + ":" + "salt")).getBytes()).equals(split[1])){
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ((HttpServletResponse)servletResponse).sendError(401);
            }
        }
    }
}
