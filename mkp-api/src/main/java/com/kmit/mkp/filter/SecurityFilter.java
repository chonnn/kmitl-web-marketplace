package com.kmit.mkp.filter;

import com.kmit.mkp.service.TokenProvider;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter implements Filter {

    private final TokenProvider tokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse respond, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpRespond = (HttpServletResponse)respond;

        httpRespond.addHeader("Access-Control-Allow-Origin", "*");
        httpRespond.addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
        httpRespond.addHeader("Access-Control-Allow-Headers","*");

        if (httpRequest.getMethod().equals("OPTIONS")) {
            httpRespond.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        String requestUrl = httpRequest.getRequestURI();
        if(!requestUrl.startsWith("/api/admin")){
            filterChain.doFilter(request, respond);
            return;
        }
        String userToken = httpRequest.getHeader("Authorization");
        if(null != userToken){
            try{
                tokenProvider.parseToken(userToken);
                filterChain.doFilter(request, respond);
            } catch (SignatureException e){
                httpRespond.sendError(HttpServletResponse.SC_UNAUTHORIZED,"");
            } catch (Exception e){
                httpRespond.sendError(HttpServletResponse.SC_UNAUTHORIZED,"");
            }
        }else{
            httpRespond.sendError(HttpServletResponse.SC_UNAUTHORIZED,"");
        }
    }
}
