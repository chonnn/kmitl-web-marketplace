package com.kmit.mkp.service;

import com.kmit.mkp.dto.UserDto;
import com.kmit.mkp.property.AuthProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private final AuthProperty authProperty;

    public String generateUserToken(UserDto userDto){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userDto.getId());
        claims.put("username", userDto.getUsername());
        claims.put("status", userDto.getStatus());
        claims.put("current_date", dateFormat.format(Calendar.getInstance().getTime()));

        return Jwts.builder().setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, authProperty.getSecretKey())
                .compact();
    }

    public UserDto parseToken(String token){

        Claims claims = Jwts.parser()
                .setSigningKey(authProperty.getSecretKey())
                .parseClaimsJws(token)
                .getBody();

        UserDto userDto = new UserDto();
        userDto.setId(claims.get("id").toString());
        userDto.setUsername(claims.get("username").toString());
        userDto.setStatus(claims.get("status").toString());

        return userDto;
    }
}
