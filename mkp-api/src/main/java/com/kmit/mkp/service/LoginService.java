package com.kmit.mkp.service;

import com.kmit.mkp.dto.LoginDto;
import com.kmit.mkp.dto.UserDto;
import com.kmit.mkp.dto.UserTokenDto;
import com.kmit.mkp.entity.UserToken;
import com.kmit.mkp.entity.Users;
import com.kmit.mkp.exception.HttpUnauthorizedException;
import com.kmit.mkp.mapper.UserMapper;
import com.kmit.mkp.repository.UserTokenRepository;
import com.kmit.mkp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UsersRepository usersRepository;
    private final UserTokenRepository userTokenRepository;
    private final TokenProvider tokenProvider;

    private final UserMapper userMapper;

    public UserTokenDto login(LoginDto loginDto){
        UserTokenDto userTokenDto = null;
        try {
            Users user = usersRepository.findUsersByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());

            userTokenDto = new UserTokenDto();
            userTokenDto.setId(user.getId());
            userTokenDto.setToken(tokenProvider.generateUserToken(userMapper.toUserDto(user)));

            UserToken userToken = userMapper.toUserToken(userTokenDto);
            userTokenRepository.save(userToken);
        }catch(Exception e){
            throw new HttpUnauthorizedException();
        }

        return userTokenDto;
    }

    public UserDto verify(UserTokenDto tokenDto) {
        UserDto userDto = null;
        try {
            userDto = tokenProvider.parseToken(tokenDto.getToken());
        }catch (Exception e){
            throw  new HttpUnauthorizedException();
        }
        return userDto;
    }

}
